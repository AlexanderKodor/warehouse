package com.alex.warehouse.dto.companyFromDadata;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Management {
    @JsonProperty("name")
    private String name;

    @JsonProperty("post")
    private String post;

    @JsonProperty("disqualified")
    private Object disqualified;
}
