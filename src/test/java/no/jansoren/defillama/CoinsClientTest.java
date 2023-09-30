package no.jansoren.defillama;

import com.fasterxml.jackson.databind.ObjectMapper;
import no.jansoren.defillama.model.coins.Coin;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.http.HttpClient;
import java.util.Map;

class CoinsClientTest {

    private CoinsClient client;

    @BeforeEach
    void before() {
        var httpClient = HttpClient.newBuilder().build();
        var objectMapper = new ObjectMapper();
        client = new CoinsClient(httpClient, objectMapper);
    }

    @Test
    void testGetPricesOfTokensByContractAddress() {
        var contractAddresses = "ethereum:0xdF574c24545E5FfEcb9a659c229253D4111d87e1,coingecko:ethereum,bsc:0x762539b45a1dcce3d36d080f74d1aed37844b878,ethereum:0xdB25f211AB05b1c97D595516F45794528a807ad8";
        var searchWidth = "4h";
        Map<String, Coin> coins = client.getPricesOfTokensByContractAddress(contractAddresses, searchWidth);
        Assertions.assertNotNull(coins);
    }

    @Test
    void testGetHistoricalPricesOfTokensByContractAddress() {
        var contractAddresses = "ethereum:0xdF574c24545E5FfEcb9a659c229253D4111d87e1,coingecko:ethereum,bsc:0x762539b45a1dcce3d36d080f74d1aed37844b878,ethereum:0xdB25f211AB05b1c97D595516F45794528a807ad8";
        var timestamp = 1648680149;
        var searchWidth = "4h";
        Map<String, Coin> coins = client.getHistoricalPricesOfTokensByContractAddress(contractAddresses, timestamp, searchWidth);
        Assertions.assertNotNull(coins);
    }

    @Test
    void testGetHistoricalPricesForMultipleTokens() {
        var contractAddresses = "{\"avax:0xb97ef9ef8734c71904d8002f8b6bc66dd9c48a6e\": [1666876743, 1666862343], \"coingecko:ethereum\": [1666869543, 1666862343]}";
        var searchWidth = "600";
        Map<String, Coin> coins = client.getHistoricalPricesForMultipleTokens(contractAddresses, searchWidth);
        Assertions.assertNotNull(coins);
    }

    @Test
    void testGetPricesAtRegularTimeIntervals() {
        var coinsStr = "ethereum:0xdF574c24545E5FfEcb9a659c229253D4111d87e1,coingecko:ethereum,bsc:0x762539b45a1dcce3d36d080f74d1aed37844b878,ethereum:0xdB25f211AB05b1c97D595516F45794528a807ad8";
        Map<String, Coin> coins = client.getPricesAtRegularTimeIntervals(coinsStr, 1664364537, null, 10, "2d", "600");
        Assertions.assertNotNull(coins);
    }

}
