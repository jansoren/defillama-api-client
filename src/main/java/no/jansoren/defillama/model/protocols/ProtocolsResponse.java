package no.jansoren.defillama.model.protocols;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ProtocolsResponse (

        @JsonProperty("protocols")
        List<Protocol> protocols
){
}
