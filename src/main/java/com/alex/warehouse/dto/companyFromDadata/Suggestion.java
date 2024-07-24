package com.alex.warehouse.dto.companyFromDadata;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Suggestion {
    @JsonProperty("value")
    private String value;

    @JsonProperty("unrestricted_value")
    private String unrestrictedValue;

    @JsonProperty("data")
    private Data data;
}
