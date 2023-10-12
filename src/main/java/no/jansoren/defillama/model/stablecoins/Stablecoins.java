package no.jansoren.defillama.model.stablecoins;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public record Stablecoins(

		@JsonProperty("peggedAssets")
		List<PeggedAssetsItem> peggedAssets
) {
}