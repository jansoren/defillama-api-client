package no.jansoren.defillama.model.protocols;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;

public class ProtocolsClient {

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public ProtocolsClient(HttpClient httpClient, ObjectMapper objectMapper) {
        this.httpClient = httpClient;
        this.objectMapper = objectMapper;
    }

    public List<Protocol> getProtocols() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(createUri("https://api.llama.fi/protocols"))
                .GET()
                .build();
        try {
            return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .thenApply(json -> fromJson(json, new TypeReference<List<Protocol>>(){}))
                    .get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    private static URI createUri(String uri) {
        try {
            return new URI(uri);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> T fromJson(String json, Class<T> clz) {
        try {
            return objectMapper.readValue(json, clz);
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    public <T> T fromJson(String json, TypeReference<T> valueTypeRef) {
        try {
            return objectMapper.readValue(json, valueTypeRef);
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

}
