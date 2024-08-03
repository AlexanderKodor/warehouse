package com.alex.warehouse.mapping;

import com.alex.warehouse.dto.companyFromDadata.*;
import com.alex.warehouse.entity.Address;
import com.alex.warehouse.entity.Company;


public class CompanyDadataMap {
    public static Company mapping(CompanyDtoDadata companyDtoDadata){
        Suggestion suggestion = companyDtoDadata.getSuggestions().get(0);
        Data data = suggestion.getData();
        AddressData addressData = data.getAddress().getAddressData();
        return Company.builder()
                .name(suggestion.getValue())
                .inn(data.getInn())
                .kpp(data.getKpp())
                .ogrn(data.getOgrn())
                .address(Address.builder()
                        .postIndex(addressData.getPostalCode())
                        .country(addressData.getCountry())
                        .region(addressData.getRegion())
                        .city(addressData.getCity())
                        .street(addressData.getStreet())
                        .house(addressData.getHouse())
                        .build())
                .phoneNumber("")
                .email("")
                .contactName("")
                .build();
    }
}
