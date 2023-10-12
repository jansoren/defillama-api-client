package no.jansoren.defillama;

import com.fasterxml.jackson.databind.ObjectMapper;
import no.jansoren.defillama.model.stablecoins.Stablecoins;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.http.HttpClient;

class StablecoinsClientTest {

    private StablecoinsClient client;

    @BeforeEach
    void before() {
        var httpClient = HttpClient.newBuilder().build();
        var objectMapper = new ObjectMapper();
        client = new StablecoinsClient(httpClient, objectMapper);
    }

    @Test
    void testGetStablecoins() {
        Stablecoins stablecoins = client.getStablecoins(true);
        Assertions.assertNotNull(stablecoins);
    }

}
