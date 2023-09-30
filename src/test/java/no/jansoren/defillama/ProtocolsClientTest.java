package no.jansoren.defillama;

import com.fasterxml.jackson.databind.ObjectMapper;
import no.jansoren.defillama.model.protocols.Protocol;
import no.jansoren.defillama.model.protocols.ProtocolItem;
import no.jansoren.defillama.model.protocols.Tvl;
import no.jansoren.defillama.model.protocols.TvlItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
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
    void testGetProtocols() {
        List<ProtocolItem> protocols = client.getProtocols();
        Assertions.assertNotNull(protocols);
    }

    @Test
    void testGetProtocol() {
        Protocol protocol = client.getProtocol("aave");
        Assertions.assertNotNull(protocol);
    }

    @Test
    void testGetTvlForAllChains() {
        List<Tvl> tvls = client.getTvlForAllChains();
        Assertions.assertNotNull(tvls);
    }

    @Test
    void testGetTvlForChain() {
        List<Tvl> tvls = client.getTvlForChain("Ethereum");
        Assertions.assertNotNull(tvls);
    }

    @Test
    void testGetTvlOfProtocol() {
        BigDecimal tvl = client.getTvlOfProtocol("uniswap");
        Assertions.assertNotNull(tvl);
    }

    @Test
    void testGetTvlForChains() {
        List<TvlItem> tvls = client.getTvlForChains();
        Assertions.assertNotNull(tvls);
    }
}
