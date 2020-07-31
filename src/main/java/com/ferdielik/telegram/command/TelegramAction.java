package com.ferdielik.telegram.command;

public interface TelegramAction
{
    void run(Long chatId, String text);
}
