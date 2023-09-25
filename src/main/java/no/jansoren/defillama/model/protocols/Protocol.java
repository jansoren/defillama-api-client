package no.jansoren.defillama.model.protocols;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public record Protocol(

    @JsonProperty("symbol")
    String symbol,

    @JsonProperty("currentChainTvls")
    CurrentChainTvls currentChainTvls,

    @JsonProperty("gecko_id")
    String geckoId,

    @JsonProperty("chains")
    List<Object> chains,

    @JsonProperty("description")
    String description,

    @JsonProperty("isParentProtocol")
    Boolean isParentProtocol,

    @JsonProperty("governanceID")
    List<String> governanceID,

    @JsonProperty("cmcId")
    String cmcId,

    @JsonProperty("twitter")
    String twitter,

    @JsonProperty("hallmarks")
    List<List<String>> hallmarks,

    @JsonProperty("raises")
    List<RaisesItem> raises,

    @JsonProperty("logo")
    String logo,

    @JsonProperty("tokens")
    List<TokensItem> tokens,

    @JsonProperty("id")
    String id,

    @JsonProperty("github")
    List<String> github,

    @JsonProperty("tokensInUsd")
    List<TokensInUsdItem> tokensInUsd,

    @JsonProperty("tvl")
    List<Tvl> tvl,

    @JsonProperty("url")
    String url,

    @JsonProperty("treasury")
    String treasury,

    @JsonProperty("wrongLiquidity")
    Boolean wrongLiquidity,

    @JsonProperty("mcap")
    Object mcap,

    @JsonProperty("otherProtocols")
    List<String> otherProtocols,

    @JsonProperty("name")
    String name,

    @JsonProperty("chainTvls")
    ChainTvls chainTvls,

    @JsonProperty("metrics")
    Object metrics
) {
}