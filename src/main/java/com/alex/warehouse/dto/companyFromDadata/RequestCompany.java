package com.alex.warehouse.dto.companyFromDadata;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestCompany {
    private String query;
    private String kpp;
}
