package com.nhavronskyi.dailyjavainterviewbot.service;

import com.nhavronskyi.dailyjavainterviewbot.props.TelegramProps;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TelegramBotService {
    private final TelegramBot telegramBot;
    private final TelegramProps props;

    public HttpStatus sendMsg(String msg) {
        try {
            telegramBot.execute(new SendMessage(props.chatId(), msg)
                    .parseMode(ParseMode.Markdown)
            );
            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
}
