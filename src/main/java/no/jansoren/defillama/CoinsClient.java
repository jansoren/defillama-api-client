package no.jansoren.defillama;

import com.fasterxml.jackson.databind.ObjectMapper;
import no.jansoren.defillama.model.coins.Coins;
import no.jansoren.defillama.model.coins.CoinsPercent;
import no.jansoren.defillama.model.protocols.BaseDefiLlamaClient;

import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class CoinsClient extends BaseDefiLlamaClient {

    public CoinsClient(HttpClient httpClient, ObjectMapper objectMapper) {
        super(httpClient, objectMapper);
    }

    public Coins getPricesOfTokensByContractAddress(String coins, String searchWidth) {
        return get(HOSTNAME_COINS+"/prices/current/"+coins+"?searchWidth="+searchWidth, Coins.class);
    }

    public Coins getHistoricalPricesOfTokensByContractAddress(String coins, int timestamp, String searchWidth) {
        return get(HOSTNAME_COINS+"/prices/historical/" + timestamp + "/" +coins+"?searchWidth="+searchWidth, Coins.class);
    }

    public Coins getHistoricalPricesForMultipleTokens(String coins, String searchWidth) {
        var coinsEncoded = URLEncoder.encode(coins, StandardCharsets.UTF_8);
        return get(HOSTNAME_COINS+"/batchHistorical?coins=" + coinsEncoded + "&searchWidth="+searchWidth, Coins.class);
    }

    public Coins getPricesAtRegularTimeIntervals(String coins, Integer start, Integer end, Integer span, String period, String searchWidth) {
        String baseUrl = HOSTNAME_COINS+"/chart/" + coins;

        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("start", start);
        queryParams.put("end", end);
        queryParams.put("span", span);
        queryParams.put("period", period);
        queryParams.put("searchWidth", searchWidth);

        String uri = queryParamsToString(baseUrl, queryParams);
        return get(uri, Coins.class);
    }

    public CoinsPercent getPercentageChangeInPriceOverTime(String coins, int timestamp, boolean lookForward, String period) {
        return get(HOSTNAME_COINS+"/percentage/"+coins+"?timestamp="+timestamp+"&lookForward="+lookForward+"&period="+period, CoinsPercent.class);
    }

    public Coins getEarliestPrice(String coins) {
        return get(HOSTNAME_COINS+"/prices/first/"+coins, Coins.class);
    }
}
