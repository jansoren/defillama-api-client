package no.jansoren.defillama.model.protocols;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public record Tvl(

    @JsonProperty("date")
    Integer date,

    @JsonProperty("tvl")
    BigDecimal tvl,

    @JsonProperty("totalLiquidityUSD")
    Object totalLiquidityUSD
) {
}