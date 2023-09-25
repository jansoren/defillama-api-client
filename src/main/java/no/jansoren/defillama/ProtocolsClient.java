package no.jansoren.defillama;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import no.jansoren.defillama.model.protocols.BaseClient;
import no.jansoren.defillama.model.protocols.Protocol;
import no.jansoren.defillama.model.protocols.ProtocolItem;
import no.jansoren.defillama.model.protocols.Tvl;
import no.jansoren.defillama.model.protocols.TvlItem;

import java.math.BigDecimal;
import java.net.http.HttpClient;
import java.util.List;

public class ProtocolsClient extends BaseClient {


    public ProtocolsClient(HttpClient httpClient, ObjectMapper objectMapper) {
        super(httpClient, objectMapper);
    }

    public List<ProtocolItem> getProtocols() {
        return get("https://api.llama.fi/protocols", new TypeReference<>(){});
    }

    public Protocol getProtocol(String protocol) {
        return get("https://api.llama.fi/protocol/"+protocol, new TypeReference<>(){});
    }

    public List<Tvl> getTvlForAllChains() {
        return get("https://api.llama.fi/v2/historicalChainTvl", new TypeReference<>(){});
    }

    public List<Tvl> getTvlForChain(String chain) {
        return get("https://api.llama.fi/v2/historicalChainTvl/"+chain, new TypeReference<>(){});
    }

    public BigDecimal getTvlOfProtocol(String protocol) {
        return get("https://api.llama.fi/tvl/"+protocol, new TypeReference<>(){});
    }

    public List<TvlItem> getTvlForChains() {
        return get("https://api.llama.fi/v2/chains", new TypeReference<>(){});
    }
}
