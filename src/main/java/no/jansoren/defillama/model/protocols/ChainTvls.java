package no.jansoren.defillama.model.protocols;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ChainTvls(

    @JsonProperty("Fantom")
    Fantom fantom,

    @JsonProperty("Arbitrum")
    Arbitrum arbitrum,

    @JsonProperty("Harmony")
    Harmony harmony,

    @JsonProperty("Avalanche-borrowed")
    AvalancheBorrowed avalancheBorrowed,

    @JsonProperty("pool2")
    Pool2 pool2,

    @JsonProperty("Metis")
    Metis metis,

    @JsonProperty("Avalanche")
    Avalanche avalanche,

    @JsonProperty("Ethereum-staking")
    EthereumStaking ethereumStaking,

    @JsonProperty("Base")
    Base base,

    @JsonProperty("Base-borrowed")
    BaseBorrowed baseBorrowed,

    @JsonProperty("Optimism")
    Optimism optimism,

    @JsonProperty("Optimism-borrowed")
    OptimismBorrowed optimismBorrowed,

    @JsonProperty("staking")
    Staking staking,

    @JsonProperty("Arbitrum-borrowed")
    ArbitrumBorrowed arbitrumBorrowed,

    @JsonProperty("Harmony-borrowed")
    HarmonyBorrowed harmonyBorrowed,

    @JsonProperty("Fantom-borrowed")
    FantomBorrowed fantomBorrowed,

    @JsonProperty("Ethereum")
    Ethereum ethereum,

    @JsonProperty("Ethereum-pool2")
    EthereumPool2 ethereumPool2,

    @JsonProperty("Metis-borrowed")
    MetisBorrowed metisBorrowed,

    @JsonProperty("Ethereum-borrowed")
    EthereumBorrowed ethereumBorrowed,

    @JsonProperty("Polygon")
    Polygon polygon,

    @JsonProperty("Polygon-borrowed")
    PolygonBorrowed polygonBorrowed,

    @JsonProperty("borrowed")
    Borrowed borrowed
) {
}