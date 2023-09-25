package no.jansoren.defillama.model.protocols;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public record AvalancheBorrowed(

    @JsonProperty("tokens")
    Object tokens,

    @JsonProperty("tvl")
    List<Tvl> tvl,

    @JsonProperty("tokensInUsd")
    Object tokensInUsd
) {
}