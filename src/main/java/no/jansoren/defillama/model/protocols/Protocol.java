package no.jansoren.defillama.model.protocols;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Protocol(

	@JsonProperty("symbol")
	String symbol,

	@JsonProperty("change_7d")
	Object change7d,

	@JsonProperty("gecko_id")
	Object geckoId,

	@JsonProperty("chains")
	List<String> chains,

	@JsonProperty("forkedFrom")
	List<Object> forkedFrom,

	@JsonProperty("audit_note")
	Object auditNote,

	@JsonProperty("description")
	String description,

	@JsonProperty("cmcId")
	Object cmcId,

	@JsonProperty("twitter")
	String twitter,

	@JsonProperty("oracles")
	List<Object> oracles,

	@JsonProperty("logo")
	String logo,

	@JsonProperty("id")
	String id,

	@JsonProperty("audits")
	String audits,

	@JsonProperty("slug")
	String slug,

	@JsonProperty("chain")
	String chain,

	@JsonProperty("address")
	Object address,

	@JsonProperty("module")
	String module,

	@JsonProperty("tvl")
	Object tvl,

	@JsonProperty("listedAt")
	int listedAt,

	@JsonProperty("url")
	String url,

	@JsonProperty("tokenBreakdowns")
	Object tokenBreakdowns,

	@JsonProperty("mcap")
	Object mcap,

	@JsonProperty("name")
	String name,

	@JsonProperty("chainTvls")
	Map<String, BigDecimal> chainTvls,

	@JsonProperty("change_1h")
	Object change1h,

	@JsonProperty("category")
	String category,

	@JsonProperty("change_1d")
	Object change1d,

	@JsonProperty("openSource")
	boolean openSource,

	@JsonProperty("governanceID")
	List<String> governanceID,

	@JsonProperty("referralUrl")
	String referralUrl,

	@JsonProperty("github")
	List<String> github,

	@JsonProperty("audit_links")
	List<String> auditLinks,

	@JsonProperty("treasury")
	String treasury
) {
}