package no.jansoren.defillama;

import com.fasterxml.jackson.databind.ObjectMapper;
import no.jansoren.defillama.model.coins.Coins;
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
