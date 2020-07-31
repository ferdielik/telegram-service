package com.ferdielik.telegram.command.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ferdielik.telegram.command.TelegramAction;
import com.ferdielik.telegram.service.TelegramService;
import com.ferdielik.telegram.util.TelegramMessageBuilder;

@Service
public class LastTelegramAction implements TelegramAction
{
    @Autowired
    InvalidTelegramAction invalidTelegramAction;

    @Autowired
    private TelegramService telegramService;

    @Override
    public void run(Long chatId, String text)
    {
        String message = TelegramMessageBuilder.newInstance()
                .append("last telegram action")
                .append("client message: " + text)
                .build();

        telegramService.sendSignal(message, chatId);
    }
}
