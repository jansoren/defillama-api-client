package no.jansoren.defillama.model.coins;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public record CoinsPercent(

    @JsonProperty("coins")
    Map<String, Double> coins
){
}
