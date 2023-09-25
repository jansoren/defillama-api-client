package no.jansoren.defillama.model.protocols;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public record TvlItem(

    @JsonProperty("cmcId")
    String cmcId,

    @JsonProperty("gecko_id")
    String geckoId,

    @JsonProperty("tokenSymbol")
    String tokenSymbol,

    @JsonProperty("chainId")
    Long chainId,

    @JsonProperty("name")
    String name,

    @JsonProperty("tvl")
    BigDecimal tvl
) {
}