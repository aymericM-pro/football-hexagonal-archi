package com.app.footballapispring.http.footballApi.rest;

import com.app.footballapispring.config.FootballApiProperties;
import com.app.footballapispring.core.base.HttpClient;
import okhttp3.HttpUrl;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.HashMap;
import java.util.Map;

@Component
public class FootballApiClient {

    private final HttpClient http;
    private final FootballApiProperties props;

    public FootballApiClient(HttpClient http, FootballApiProperties props) {
        this.http = http;
        this.props = props;
    }

    public JsonNode get(String path, Map<String, String> params) {

        HttpUrl.Builder url = HttpUrl.parse(props.getBaseUrl() + path).newBuilder();
        params.forEach(url::addQueryParameter);

        Map<String, String> headers = new HashMap<>();
        headers.put("x-apisports-key", props.getKey());

        JsonNode root = http.get(url.build().toString(), headers);

        return root.path("response");
    }
}