package com.alex.warehouse.dto.companyFromDadata;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Opf {
    @JsonProperty("type")
    private String type;

    @JsonProperty("code")
    private String code;

    @JsonProperty("full")
    private String full;

    @JsonProperty("short")
    private String shortName;
}
