package com.ferdielik.telegram.service;

import com.ferdielik.telegram.domain.TelegramUpdate;

public interface TelegramService
{
    void sendSignal(String message, Long chatId);

    void doUpdate(TelegramUpdate update);
}
