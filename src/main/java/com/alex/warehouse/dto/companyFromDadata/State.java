package com.alex.warehouse.dto.companyFromDadata;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class State {
    @JsonProperty("status")
    private String status;

    @JsonProperty("code")
    private Object code;

    @JsonProperty("actuality_date")
    private long actualityDate;

    @JsonProperty("registration_date")
    private long registrationDate;

    @JsonProperty("liquidation_date")
    private Object liquidationDate;
}
