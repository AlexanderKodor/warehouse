package com.alex.warehouse.dto.companyFromDadata;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
    @JsonProperty("value")
    private String value;

    @JsonProperty("unrestricted_value")
    private String unrestrictedValue;

    @JsonProperty("invalidity")
    private Object invalidity;

    @JsonProperty("data")
    private AddressData addressData;
}
