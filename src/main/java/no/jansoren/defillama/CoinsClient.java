package no.jansoren.defillama;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import no.jansoren.defillama.model.coins.Coins;
import no.jansoren.defillama.model.protocols.BaseClient;

import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.nio.charset.StandardCharsets;

public class CoinsClient extends BaseClient {

    public CoinsClient(HttpClient httpClient, ObjectMapper objectMapper) {
        super(httpClient, objectMapper);
    }

    public Coins getPricesOfTokensByContractAddress(String coins, String searchWidth) {
        return get("https://coins.llama.fi/prices/current/"+coins+"?searchWidth="+searchWidth, new TypeReference<>(){});
    }

    public Coins getHistoricalPricesOfTokensByContractAddress(String coins, int timestamp, String searchWidth) {
        return get("https://coins.llama.fi/prices/historical/" + timestamp + "/" +coins+"?searchWidth="+searchWidth, new TypeReference<>(){});
    }

    public Coins getHistoricalPricesForMultipleTokens(String coins, String searchWidth) {
        var coinsEncoded = URLEncoder.encode(coins, StandardCharsets.UTF_8);
        return get("https://coins.llama.fi/batchHistorical?coins=" + coinsEncoded + "&searchWidth="+searchWidth, new TypeReference<>(){});
    }
}
