package no.jansoren.defillama;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import no.jansoren.defillama.model.coins.Coins;
import no.jansoren.defillama.model.protocols.BaseClient;

import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

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

    public Coins getPricesAtRegularTimeIntervals(String coins, Integer start, Integer end, Integer span, String period, String searchWidth) {
        String baseUrl = "https://coins.llama.fi/chart/" + coins;

        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("start", start);
        queryParams.put("end", end);
        queryParams.put("span", span);
        queryParams.put("period", period);
        queryParams.put("searchWidth", searchWidth);

        String uri = queryParamsToString(baseUrl, queryParams);
        return get(uri, new TypeReference<>(){});
    }

    private static String queryParamsToString(String baseUrl, Map<String, Object> queryParams) {
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

}
