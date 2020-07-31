package com.ferdielik.telegram.domain;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class TelegramResponse implements Serializable
{
    private boolean ok;
    private List<TelegramUpdate> result;
}