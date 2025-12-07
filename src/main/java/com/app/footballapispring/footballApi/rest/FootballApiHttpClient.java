package com.app.footballapispring.footballApi.rest;

import com.app.footballapispring.core.error.FootballApiError;
import com.app.footballapispring.core.error.FootballApiException;
import okhttp3.*;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

@Component
public class FootballApiHttpClient {

    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper mapper = new ObjectMapper();
    private final static String API_KEY_PROPERTIES = "x-apisports-key";

    public JsonNode get(String url, String apiKey) {

        Request request = new Request.Builder()
                .url(url)
                .addHeader(API_KEY_PROPERTIES, apiKey)
                .build();

        try (Response response = client.newCall(request).execute()) {

            int status = response.code();

            if (!response.isSuccessful()) {
                FootballApiError error = FootballApiError.fromHttpStatus(status);
                throw new FootballApiException(error);
            }

            return mapper.readTree(response.body().string());

        } catch (IOException e) {
            throw new FootballApiException(
                    FootballApiError.INTERNAL_ERROR,
                    "Network error: " + e.getMessage()
            );
        }
    }
}

