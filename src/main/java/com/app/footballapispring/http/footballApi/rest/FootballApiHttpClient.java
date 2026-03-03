package com.app.footballapispring.http.footballApi.rest;

import com.app.footballapispring.core.errors.FootballApiError;
import com.app.footballapispring.core.errors.FootballApiException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class FootballApiHttpClient {

    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper mapper = new ObjectMapper();
    private static final String API_KEY_PROPERTIES = "x-apisports-key";

    public JsonNode get(String url, String apiKey) {

        Request request = new Request.Builder()
                .url(url)
                .addHeader(API_KEY_PROPERTIES, apiKey)
                .build();

        try (Response response = client.newCall(request).execute()) {

            HttpStatus status = HttpStatus.resolve(response.code());

            if (status == null || !status.is2xxSuccessful()) {

                FootballApiError error = status != null
                        ? FootballApiError.fromHttpStatus(status)
                        : FootballApiError.INTERNAL_ERROR;

                throw new FootballApiException(error);
            }

            ResponseBody body = response.body();
            if (body == null) {
                throw new FootballApiException(
                        FootballApiError.INTERNAL_ERROR,
                        "Empty response body"
                );
            }

            return mapper.readTree(body.string());

        } catch (IOException e) {
            throw new FootballApiException(
                    FootballApiError.INTERNAL_ERROR,
                    "Network error: " + e.getMessage()
            );
        }
    }
}