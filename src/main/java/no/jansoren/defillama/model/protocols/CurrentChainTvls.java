package no.jansoren.defillama.model.protocols;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CurrentChainTvls(

    @JsonProperty("Fantom")
    Object fantom,

    @JsonProperty("Arbitrum")
    Object arbitrum,

    @JsonProperty("Harmony")
    Integer harmony,

    @JsonProperty("Avalanche-borrowed")
    Object avalancheBorrowed,

    @JsonProperty("pool2")
    Object pool2,

    @JsonProperty("Metis")
    Object metis,

    @JsonProperty("Avalanche")
    Object avalanche,

    @JsonProperty("Ethereum-staking")
    Object ethereumStaking,

    @JsonProperty("Base")
    Object base,

    @JsonProperty("Base-borrowed")
    Object baseBorrowed,

    @JsonProperty("Optimism")
    Object optimism,

    @JsonProperty("Optimism-borrowed")
    Object optimismBorrowed,

    @JsonProperty("staking")
    Object staking,

    @JsonProperty("Arbitrum-borrowed")
    Object arbitrumBorrowed,

    @JsonProperty("Harmony-borrowed")
    Object harmonyBorrowed,

    @JsonProperty("Fantom-borrowed")
    Object fantomBorrowed,

    @JsonProperty("Ethereum")
    Object ethereum,

    @JsonProperty("Ethereum-pool2")
    Object ethereumPool2,

    @JsonProperty("Metis-borrowed")
    Object metisBorrowed,

    @JsonProperty("Ethereum-borrowed")
    Object ethereumBorrowed,

    @JsonProperty("Polygon")
    Object polygon,

    @JsonProperty("Polygon-borrowed")
    Object polygonBorrowed,

    @JsonProperty("borrowed")
    Object borrowed
) {
}