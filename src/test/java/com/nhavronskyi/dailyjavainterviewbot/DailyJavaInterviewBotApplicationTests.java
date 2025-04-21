package com.nhavronskyi.dailyjavainterviewbot;

import com.nhavronskyi.dailyjavainterviewbot.service.GeminiService;
import com.nhavronskyi.dailyjavainterviewbot.service.TelegramBotService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.function.Supplier;

@SpringBootTest
@ActiveProfiles("test")
class DailyJavaInterviewBotApplicationTests {

    @MockitoBean
    private TelegramBotService telegramBotService;
    @MockitoBean
    private GeminiService geminiService;
    @MockitoBean
    private Supplier<String> sendQuestions;

    @Test
    void contextLoads() {
    }

}
