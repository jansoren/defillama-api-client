package no.jansoren.defillama.model.stablecoins;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PeggedAssetsItem(

		@JsonProperty("symbol")
		String symbol,

		@JsonProperty("chainCirculating")
		Map<String, Map<String, Object>> chainCirculating,

		@JsonProperty("gecko_id")
		String geckoId,

		@JsonProperty("chains")
		List<String> chains,

		@JsonProperty("circulatingPrevWeek")
		Map<String, BigDecimal> circulatingPrevWeek,

		@JsonProperty("pegType")
		String pegType,

		@JsonProperty("circulatingPrevMonth")
		Object circulatingPrevMonth,

		@JsonProperty("pegMechanism")
		String pegMechanism,

		@JsonProperty("circulating")
		Map<String, BigDecimal> circulating,

		@JsonProperty("circulatingPrevDay")
		Map<String, BigDecimal> circulatingPrevDay,

		@JsonProperty("price")
		int price,

		@JsonProperty("priceSource")
		String priceSource,

		@JsonProperty("name")
		String name,

		@JsonProperty("id")
		String id
) {
}