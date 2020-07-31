package com.ferdielik.telegram.domain;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class TelegramMessage
{
    @SerializedName("message_id")
    private Long id;
    private TelegramUser from;
    private Date date;
    private String text;

}
