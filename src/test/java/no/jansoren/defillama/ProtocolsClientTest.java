package no.jansoren.defillama;

import com.fasterxml.jackson.databind.ObjectMapper;
import no.jansoren.defillama.model.protocols.Protocol;
import no.jansoren.defillama.model.protocols.ProtocolsClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.http.HttpClient;
import java.util.List;

public class ProtocolsClientTest {

    private ProtocolsClient client;

    @BeforeEach
    void before() {
        var httpClient = HttpClient.newBuilder().build();
        var objectMapper = new ObjectMapper();
        client = new ProtocolsClient(httpClient, objectMapper);
    }

    @Test
    void test() {
        List<Protocol> protocols = client.getProtocols();
        Assertions.assertNotNull(protocols);
    }
}
