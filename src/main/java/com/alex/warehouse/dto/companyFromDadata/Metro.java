package com.alex.warehouse.dto.companyFromDadata;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Metro {
    @JsonProperty("name")
    private String name;

    @JsonProperty("line")
    private String line;

    @JsonProperty("distance")
    private double distance;
}
