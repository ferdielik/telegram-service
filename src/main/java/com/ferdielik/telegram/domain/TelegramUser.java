package com.ferdielik.telegram.domain;


import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class TelegramUser
{
    private Long id;

    @SerializedName("is_bot")
    private boolean isBot;

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("last_name")
    private String lastName;

    private String username;

    @SerializedName("language_code")
    private String languageCode;

}
