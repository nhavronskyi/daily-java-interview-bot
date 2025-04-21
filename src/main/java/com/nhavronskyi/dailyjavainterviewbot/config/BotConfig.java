package com.nhavronskyi.dailyjavainterviewbot.config;

import com.nhavronskyi.dailyjavainterviewbot.props.TelegramProps;
import com.pengrad.telegrambot.TelegramBot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BotConfig {
    @Bean
    public TelegramBot telegramBot(TelegramProps props) {
        return new TelegramBot(props.token());
    }
}
