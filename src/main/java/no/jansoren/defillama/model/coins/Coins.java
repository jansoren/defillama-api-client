package no.jansoren.defillama.model.coins;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public record Coins(

    @JsonProperty("coins")
    Map<String, Coin> coins
){
}
