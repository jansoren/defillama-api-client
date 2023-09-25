package no.jansoren.defillama.model.protocols;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TokensItem(

    @JsonProperty("date")
    Integer date,

    @JsonProperty("tokens")
    Tokens tokens
) {
}