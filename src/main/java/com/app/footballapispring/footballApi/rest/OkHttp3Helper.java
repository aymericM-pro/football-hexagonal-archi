package com.app.footballapispring.footballApi.rest;

import com.app.footballapispring.config.FootballApiProperties;
import okhttp3.HttpUrl;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.Map;

@Component
public class OkHttp3Helper {

    private final FootballApiHttpClient http;
    private final FootballApiProperties props;

    public OkHttp3Helper(FootballApiHttpClient http, FootballApiProperties props) {
        this.http = http;
        this.props = props;
    }

    public JsonNode get(String path, Map<String, String> params) {
        HttpUrl.Builder url = HttpUrl.parse(props.getBaseUrl() + path).newBuilder();
        params.forEach(url::addQueryParameter);
        JsonNode root = http.get(url.build().toString(), props.getKey());
        return root.path("response");
    }
}
