package com.nhavronskyi.dailyjavainterviewbot.service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.nhavronskyi.dailyjavainterviewbot.props.GoogleProps;
import com.nhavronskyi.dailyjavainterviewbot.service.model.GoogleGeminiRequest;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GeminiService {
    private final GoogleProps googleProps;
    private final Gson gson;

    private static String getAnswerFromJson(String json) {
        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        JsonArray candidates = jsonObject.getAsJsonArray("candidates");
        JsonObject firstCandidate = candidates.get(0).getAsJsonObject();
        JsonObject content = firstCandidate.getAsJsonObject("content");
        JsonArray parts = content.getAsJsonArray("parts");
        JsonObject firstPart = parts.get(0).getAsJsonObject();
        return firstPart.get("text").getAsString();
    }

    @SneakyThrows
    public String getQuestionsForToday() {
        String endpoint = googleProps.url().geminiUrl() + googleProps.apiKey();

        String prompt = """
                Please send me 5 random questions for middle java developer interview.
                
                ---
                convert a message to markdown format.
                """;
        String googleGeminiResponseBody = new GoogleGeminiRequest(endpoint, prompt, gson)
                .execute()
                .body();

        return getAnswerFromJson(googleGeminiResponseBody);
    }
}
