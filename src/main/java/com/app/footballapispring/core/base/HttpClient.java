package com.app.footballapispring.core.base;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class HttpClient {

    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper mapper = new ObjectMapper();

    public JsonNode get(String url, Map<String, String> headers) {
        Request.Builder requestBuilder = new Request.Builder()
                .url(url)
                .get();

        headers.forEach(requestBuilder::addHeader);

        try (Response response = client.newCall(requestBuilder.build()).execute()) {

            if (!response.isSuccessful()) {
                throw new RuntimeException("HTTP error: " + response.code());
            }

            return mapper.readTree(response.body().string());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
