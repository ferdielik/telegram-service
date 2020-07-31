package com.ferdielik.telegram.util;

import java.util.Map;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.util.EntityUtils;


public final class HttpUtil
{
    private final static int DEFAULT_TIMEOUT = 7 * 1000;

    public static String get(String url, Map<String, String> headers) throws Exception
    {
        HttpGet httpReq = new HttpGet(url);
        return connect(httpReq, headers);
    }

    private static String connect(HttpRequestBase method, Map<String, String> headers) throws Exception
    {
        CloseableHttpResponse response;

        RequestConfig.Builder requestBuilder = RequestConfig.custom()
                .setRedirectsEnabled(true)
                .setConnectTimeout(DEFAULT_TIMEOUT)
                .setConnectionRequestTimeout(DEFAULT_TIMEOUT);

        CloseableHttpClient client = HttpClients.custom()
                .setRedirectStrategy(LaxRedirectStrategy.INSTANCE)
                .setRetryHandler(new DefaultHttpRequestRetryHandler(3, false))
                .setDefaultRequestConfig(requestBuilder.build())
                .build();

        try
        {
            addHeadersIfExist(method, headers);
            response = client.execute(method);
            return EntityUtils.toString(response.getEntity());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            method.releaseConnection();
            client.close();
        }

        throw new Exception("something wrong");
    }

    private static void addHeadersIfExist(HttpRequestBase method, Map<String, String> headers)
    {
        if (headers != null && headers.size() > 0)
        {
            for (String key : headers.keySet())
            {
                method.setHeader(key, headers.get(key));
            }
        }
    }
}

