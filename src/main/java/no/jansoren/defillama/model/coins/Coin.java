package no.jansoren.defillama.model.coins;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.List;

public record Coin(

    @JsonProperty("symbol")
    String symbol,

    @JsonProperty("price")
    BigDecimal price,

    @JsonProperty("prices")
    List<PricesItem> prices,

    @JsonProperty("decimals")
    Integer decimals,

    @JsonProperty("confidence")
    BigDecimal confidence,

    @JsonProperty("timestamp")
    Integer timestamp
) {
}