package com.ferdielik.telegram.util;

public class TelegramMessageBuilder
{
    private String text = "";

    public static TelegramMessageBuilder newInstance()
    {
        return new TelegramMessageBuilder();
    }

    public TelegramMessageBuilder append(String text, Object... args)
    {
        this.text += String.format(text, args);
        return this;
    }

    public TelegramMessageBuilder bold(String text, Object... args)
    {
        return append("<b>" + text + "</b>", args);
    }

    public TelegramMessageBuilder pre(String text, Object... args)
    {
        return append("<b>" + text + "</b>", args);
    }

    public TelegramMessageBuilder code(String text, Object... args)
    {
        return append("<code>" + text + "</code>", args);
    }

    public TelegramMessageBuilder newLine()
    {
        return append("\n");
    }

    public TelegramMessageBuilder italic(String text, Object... args)
    {
        return append("<i>" + text + "</i>", args);
    }

    public TelegramMessageBuilder link(String text, String url, Object... args)
    {
        return append("<a href=\"" + url + "\">" + text + "</a>", args);
    }

    public String build()
    {
        return text;
    }
}
