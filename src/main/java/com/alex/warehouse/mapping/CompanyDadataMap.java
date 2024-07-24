package com.alex.warehouse.mapping;

import com.alex.warehouse.dto.companyFromDadata.*;
import com.alex.warehouse.entity.Address;
import com.alex.warehouse.entity.Company;


public class CompanyDadataMap {
    public static Company mapping(CompanyDtoDadata companyDtoDadata){
        return Company.builder()
                .name(companyDtoDadata.getSuggestions().get(0).getValue())
                .inn(companyDtoDadata.getSuggestions().get(0).getData().getInn())
                .kpp(companyDtoDadata.getSuggestions().get(0).getData().getKpp())
                .ogrn(companyDtoDadata.getSuggestions().get(0).getData().getOgrn())
                .address(Address.builder()
                        .postIndex(companyDtoDadata.getSuggestions().get(0).getData().getAddress().getAddressData().getPostalCode())
                        .country(companyDtoDadata.getSuggestions().get(0).getData().getAddress().getAddressData().getCountry())
                        .region(companyDtoDadata.getSuggestions().get(0).getData().getAddress().getAddressData().getRegion())
                        .city(companyDtoDadata.getSuggestions().get(0).getData().getAddress().getAddressData().getCity())
                        .street(companyDtoDadata.getSuggestions().get(0).getData().getAddress().getAddressData().getStreet())
                        .house(companyDtoDadata.getSuggestions().get(0).getData().getAddress().getAddressData().getHouse())
                        .build())
                .phoneNumber("")
                .email("")
                .contactName("")
                .build();
    }
}
