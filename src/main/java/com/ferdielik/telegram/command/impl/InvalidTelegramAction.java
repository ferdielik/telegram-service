package com.ferdielik.telegram.command.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ferdielik.telegram.command.TelegramAction;
import com.ferdielik.telegram.service.TelegramService;

@Service
public class InvalidTelegramAction implements TelegramAction
{
    @Autowired
    TelegramService telegramService;

    @Override
    public void run(Long chatId, String text)
    {
        telegramService.sendSignal("Invalid command", chatId);
    }
}
