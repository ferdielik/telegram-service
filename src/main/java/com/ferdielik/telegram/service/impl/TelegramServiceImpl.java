package com.ferdielik.telegram.service.impl;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.ferdielik.telegram.action.TelegramCommand;
import com.ferdielik.telegram.command.TelegramAction;
import com.ferdielik.telegram.domain.TelegramMessage;
import com.ferdielik.telegram.domain.TelegramUpdate;
import com.ferdielik.telegram.service.TelegramService;
import com.ferdielik.telegram.util.Constants;
import com.ferdielik.telegram.util.Constants.Telagram;
import com.ferdielik.telegram.util.HttpUtil;
import com.ferdielik.telegram.util.TelegramMessageBuilder;

@Service
public class TelegramServiceImpl implements TelegramService
{
    private static final Logger logger = LoggerFactory.getLogger(TelegramServiceImpl.class);

    @Autowired
    ApplicationContext context;

    @Override
    public void sendSignal(String message, Long chatId)
    {
        try
        {
            message = URLEncoder.encode(message, StandardCharsets.UTF_8.toString());
            HttpUtil.get(String.format(Constants.Telagram.API_URL, Telagram.BOT_API_KEY, chatId, message), null);

            logger.error("signal sent with chat id: {} and message: {} ", chatId, message);
        }
        catch (Exception e)
        {
            logger.error("Exception caught while signal sending ", e);
        }
    }

    // this method called when a message came to a bot
    // you must give an api endpoint for handling messages

    @Override
    public void doUpdate(TelegramUpdate update)
    {
        logger.error("telegram update: {}", update);

        TelegramMessage message = update.getMessage();
        Long chatId = message.getFrom().getId();

        TelegramCommand command = TelegramCommand.getCommand(message.getText());
        TelegramAction telegramAction = context.getBean(command.getClassN(), TelegramAction.class);

        telegramAction.run(chatId, update.getMessage().getText());
    }
}
