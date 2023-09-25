package no.jansoren.defillama.model.protocols;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProtocolItem(
        @JsonProperty("symbol")
        String symbol,

        @JsonProperty("change_7d")
        BigDecimal change7d,

        @JsonProperty("gecko_id")
        String geckoId,

        @JsonProperty("chains")
        List<String> chains,

        @JsonProperty("forkedFrom")
        List<Object> forkedFrom,

        @JsonProperty("audit_note")
        String auditNote,

        @JsonProperty("description")
        String description,

        @JsonProperty("cmcId")
        String cmcId,

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
        String address,

        @JsonProperty("module")
        String module,

        @JsonProperty("tvl")
        BigDecimal tvl,

        @JsonProperty("listedAt")
        int listedAt,

        @JsonProperty("url")
        String url,

        @JsonProperty("tokenBreakdowns")
        Object tokenBreakdowns,

        @JsonProperty("mcap")
        BigDecimal mcap,

        @JsonProperty("name")
        String name,

        @JsonProperty("chainTvls")
        Map<String, BigDecimal> chainTvls,

        @JsonProperty("change_1h")
        BigDecimal change1h,

        @JsonProperty("category")
        String category,

        @JsonProperty("change_1d")
        BigDecimal change1d,

        @JsonProperty("pool2")
        BigDecimal pool2,

        @JsonProperty("staking")
        BigDecimal staking,

        @JsonProperty("github")
        List<String> github,

        @JsonProperty("treasury")
        String treasury,

        @JsonProperty("audit_links")
        List<String> auditLinks,

        @JsonProperty("parentProtocol")
        String parentProtocol,

        @JsonProperty("governanceID")
        List<String> governanceID,

        @JsonProperty("rugged")
        boolean rugged,

        @JsonProperty("wrongLiquidity")
        boolean wrongLiquidity,

        @JsonProperty("deadUrl")
        boolean deadUrl,

        @JsonProperty("stablecoins")
        List<String> stablecoins,

        @JsonProperty("openSource")
        boolean openSource,

        @JsonProperty("language")
        String language,

        @JsonProperty("referralUrl")
        String referralUrl,

        @JsonProperty("assetToken")
        String assetToken,

        @JsonProperty("oraclesByChain")
        Map<String, List<String>> oraclesByChain
) {
}