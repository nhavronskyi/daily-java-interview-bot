package com.nhavronskyi.dailyjavainterviewbot;

import com.nhavronskyi.dailyjavainterviewbot.service.GeminiService;
import com.nhavronskyi.dailyjavainterviewbot.service.TelegramBotService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

import java.util.function.Supplier;

@SpringBootApplication
@ConfigurationPropertiesScan
@RequiredArgsConstructor
public class DailyJavaInterviewBotApplication {

    private final TelegramBotService telegramBotService;
    private final GeminiService geminiService;

    @Bean
    public Supplier<HttpStatus> sendQuestions() {
        return () -> telegramBotService.sendMsg(geminiService.getQuestionsForToday());
    }

    public static void main(String[] args) {
        SpringApplication.run(DailyJavaInterviewBotApplication.class, args);
    }

}
