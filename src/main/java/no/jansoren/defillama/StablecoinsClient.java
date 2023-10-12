package no.jansoren.defillama;

import com.fasterxml.jackson.databind.ObjectMapper;
import no.jansoren.defillama.model.protocols.BaseDefiLlamaClient;
import no.jansoren.defillama.model.stablecoins.Stablecoins;

import java.net.http.HttpClient;

public class StablecoinsClient extends BaseDefiLlamaClient {

    public StablecoinsClient(HttpClient httpClient, ObjectMapper objectMapper) {
        super(httpClient, objectMapper);
    }

    public Stablecoins getStablecoins(boolean includePrices) {
        return get(HOSTNAME_STABLECOINS+"/stablecoins?includePrices="+includePrices, Stablecoins.class);
    }

    // TODO - Work in progress

}
