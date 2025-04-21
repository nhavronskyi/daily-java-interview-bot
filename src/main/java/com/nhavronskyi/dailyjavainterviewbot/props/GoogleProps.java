package com.nhavronskyi.dailyjavainterviewbot.props;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "google")
public record GoogleProps(
        String apiKey,
        String refreshToken,
        UrlProps url
) {
    public record UrlProps(
            String redirectUrl,
            String geminiUrl
    ) {
    }
}
