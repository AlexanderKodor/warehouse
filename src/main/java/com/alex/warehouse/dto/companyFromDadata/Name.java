package com.alex.warehouse.dto.companyFromDadata;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Name {
    @JsonProperty("full_with_opf")
    private String fullWithOpf;

    @JsonProperty("short_with_opf")
    private String shortWithOpf;

    @JsonProperty("latin")
    private Object latin;

    @JsonProperty("full")
    private String full;

    @JsonProperty("short")
    private String shortName;
}