package no.jansoren.defillama.model.protocols;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ChainTvls(

	@JsonProperty("Arbitrum")
	Object arbitrum,

	@JsonProperty("Ethereum")
	Object ethereum,

	@JsonProperty("Bitcoin")
	Object bitcoin,

	@JsonProperty("Tron")
	Object tron,

	@JsonProperty("Polygon")
	Object polygon,

	@JsonProperty("Avalanche")
	Object avalanche,

	@JsonProperty("Optimism")
	Object optimism,

	@JsonProperty("Moonriver")
	Object moonriver,

	@JsonProperty("Solana")
	Object solana,

	@JsonProperty("Moonbeam")
	Object moonbeam,

	@JsonProperty("Terra")
	int terra,

	@JsonProperty("Aptos")
	Object aptos,

	@JsonProperty("Litecoin")
	Object litecoin,

	@JsonProperty("Polkadot")
	Object polkadot,

	@JsonProperty("Binance")
	Object binance,

	@JsonProperty("Ripple")
	Object ripple,

	@JsonProperty("Algorand")
	Object algorand
) {
}