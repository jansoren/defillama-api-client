package no.jansoren.defillama.model.protocols;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class BaseDefiLlamaClient {

    protected static final String HOSTNAME_API = "https://api.llama.fi";
    protected static final String HOSTNAME_COINS = "https://coins.llama.fi";
    protected static final String HOSTNAME_STABLECOINS = "https://stablecoins.llama.fi";
    protected final HttpClient httpClient;
    protected final ObjectMapper objectMapper;

    public BaseDefiLlamaClient(HttpClient httpClient, ObjectMapper objectMapper) {
        this.httpClient = httpClient;
        this.objectMapper = objectMapper;
    }

    protected <T> T get(String uri, Class<T> clz) {
        try {
            return httpClient.sendAsync(createGetRequest(uri), HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .thenApply(json -> fromJson(json, clz))
                    .get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
    protected <T> T get(String uri) {
        return get(uri, new TypeReference<>(){});
    }

    protected <T> T get(String uri, TypeReference<T> valueTypeRef) {
        try {
            return httpClient.sendAsync(createGetRequest(uri), HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .thenApply(json -> fromJson(json, valueTypeRef))
                    .get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    protected static String queryParamsToString(String baseUrl, Map<String, Object> queryParams) {
        StringBuilder urlBuilder = new StringBuilder(baseUrl);
        boolean isFirstParam = true;

        for (Map.Entry<String, Object> entry : queryParams.entrySet()) {
            var key = entry.getKey();
            var value = toString(entry.getValue());

            if (value != null) {
                if (isFirstParam) {
                    urlBuilder.append("?");
                    isFirstParam = false;
                } else {
                    urlBuilder.append("&");
                }
                urlBuilder.append(key).append("=").append(value);
            }
        }
        return urlBuilder.toString();
    }

    private static String toString(Object value) {
        if(value != null)
            return value.toString();
        return null;
    }

    private HttpRequest createGetRequest(String uri) {
        return HttpRequest.newBuilder()
                .uri(createUri(uri))
                .GET()
                .build();
    }

    private URI createUri(String uri) {
        try {
            return new URI(uri);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    private <T> T fromJson(String json, Class<T> clz) {
        try {
            return objectMapper.readValue(json, clz);
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    private <T> T fromJson(String json, TypeReference<T> valueTypeRef) {
        try {
            return objectMapper.readValue(json, valueTypeRef);
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }
}
