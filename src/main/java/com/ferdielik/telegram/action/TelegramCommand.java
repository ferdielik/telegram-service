package com.ferdielik.telegram.action;

import com.ferdielik.telegram.command.TelegramAction;
import com.ferdielik.telegram.command.impl.InvalidTelegramAction;
import com.ferdielik.telegram.command.impl.LastTelegramAction;

public enum TelegramCommand
{
    LAST("/last", LastTelegramAction.class),
    INVALID("/invalid", InvalidTelegramAction.class);

    private String suffix;
    private Class<? extends TelegramAction> action;

    TelegramCommand(String update, Class<? extends TelegramAction> action)
    {
        this.suffix = update;
        this.action = action;
    }

    public static TelegramCommand getCommand(String text)
    {
        for (TelegramCommand command : TelegramCommand.values())
        {
            if (text.startsWith(command.getSuffix()))
            {
                return command;
            }
        }
        return TelegramCommand.INVALID;
    }

    public String getClassN()
    {
        return action.getSimpleName().substring(0, 1).toLowerCase() + action.getSimpleName().substring(1);
    }

    public String getSuffix()
    {
        return suffix;
    }
}
