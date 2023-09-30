package no.jansoren.defillama;

import com.fasterxml.jackson.databind.ObjectMapper;
import no.jansoren.defillama.model.protocols.BaseDefiLlamaClient;
import no.jansoren.defillama.model.protocols.Protocol;
import no.jansoren.defillama.model.protocols.ProtocolItem;
import no.jansoren.defillama.model.protocols.Tvl;
import no.jansoren.defillama.model.protocols.TvlItem;

import java.math.BigDecimal;
import java.net.http.HttpClient;
import java.util.List;

public class ProtocolsClient extends BaseDefiLlamaClient {

    public ProtocolsClient(HttpClient httpClient, ObjectMapper objectMapper) {
        super(httpClient, objectMapper);
    }

    public List<ProtocolItem> getProtocols() {
        return get(HOSTNAME_API+"/protocols");
    }

    public Protocol getProtocol(String protocol) {
        return get(HOSTNAME_API+"/protocol/"+protocol, Protocol.class);
    }

    public List<Tvl> getTvlForAllChains() {
        return get(HOSTNAME_API+"/v2/historicalChainTvl");
    }

    public List<Tvl> getTvlForChain(String chain) {
        return get(HOSTNAME_API+"/v2/historicalChainTvl/"+chain);
    }

    public BigDecimal getTvlOfProtocol(String protocol) {
        return get(HOSTNAME_API+"/tvl/"+protocol, BigDecimal.class);
    }

    public List<TvlItem> getTvlForChains() {
        return get(HOSTNAME_API+"/v2/chains");
    }
}
