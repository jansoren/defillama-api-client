package no.jansoren.defillama.model.coins;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public record PricesItem(

    @JsonProperty("price")
    BigDecimal price,

    @JsonProperty("confidence")
    BigDecimal confidence,

    @JsonProperty("timestamp")
    int timestamp
) {
}