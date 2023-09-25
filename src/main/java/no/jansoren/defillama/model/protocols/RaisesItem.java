package no.jansoren.defillama.model.protocols;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public record RaisesItem(

    @JsonProperty("date")
    Integer date,

    @JsonProperty("amount")
    Integer amount,

    @JsonProperty("leadInvestors")
    List<String> leadInvestors,

    @JsonProperty("valuation")
    Object valuation,

    @JsonProperty("round")
    String round,

    @JsonProperty("chains")
    List<String> chains,

    @JsonProperty("otherInvestors")
    List<Object> otherInvestors,

    @JsonProperty("name")
    String name,

    @JsonProperty("defillamaId")
    String defillamaId,

    @JsonProperty("source")
    String source,

    @JsonProperty("category")
    String category,

    @JsonProperty("sector")
    String sector
) {
}