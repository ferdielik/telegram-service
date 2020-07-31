package com.ferdielik.telegram.util;

public class Constants
{
    public interface Telagram
    {
        String BOT_API_KEY = "";
        String API_URL = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s&parse_mode=HTML";
    }
}
