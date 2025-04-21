package com.nhavronskyi.dailyjavainterviewbot;

import com.nhavronskyi.dailyjavainterviewbot.service.GeminiService;
import com.nhavronskyi.dailyjavainterviewbot.service.TelegramBotService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;

import java.util.function.Supplier;

@SpringBootApplication
@ConfigurationPropertiesScan
@RequiredArgsConstructor
public class DailyJavaInterviewBotApplication {

    private final TelegramBotService telegramBotService;
    private final GeminiService geminiService;

    @Bean
    public Supplier<String> sendQuestions() {
        var status = telegramBotService.sendMsg(geminiService.getQuestionsForToday());
        return status::toString;
    }

    public static void main(String[] args) {
        SpringApplication.run(DailyJavaInterviewBotApplication.class, args);
    }

}
