package com.ferdielik.telegram.domain;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class TelegramUpdate
{
    @SerializedName("update_id")
    private Long id;

    private TelegramMessage message;
}
