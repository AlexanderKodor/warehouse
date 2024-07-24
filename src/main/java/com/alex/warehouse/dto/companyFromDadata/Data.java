package com.alex.warehouse.dto.companyFromDadata;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Data {
    @JsonProperty("kpp")
    private String kpp;

    @JsonProperty("capital")
    private Object capital;

    @JsonProperty("invalid")
    private Object invalid;

    @JsonProperty("management")
    private Management management;

    @JsonProperty("founders")
    private Object founders;

    @JsonProperty("managers")
    private Object managers;

    @JsonProperty("predecessors")
    private Object predecessors;

    @JsonProperty("successors")
    private Object successors;

    @JsonProperty("branch_type")
    private String branchType;

    @JsonProperty("branch_count")
    private int branchCount;

    @JsonProperty("source")
    private Object source;

    @JsonProperty("qc")
    private Object qc;

    @JsonProperty("hid")
    private String hid;

    @JsonProperty("type")
    private String type;

    @JsonProperty("state")
    private State state;

    @JsonProperty("opf")
    private Opf opf;

    @JsonProperty("name")
    private Name name;

    @JsonProperty("inn")
    private String inn;

    @JsonProperty("ogrn")
    private String ogrn;

    @JsonProperty("okpo")
    private String okpo;

    @JsonProperty("okato")
    private String okato;

    @JsonProperty("oktmo")
    private String oktmo;

    @JsonProperty("okogu")
    private String okogu;

    @JsonProperty("okfs")
    private String okfs;

    @JsonProperty("okved")
    private String okved;

    @JsonProperty("okveds")
    private Object okveds;

    @JsonProperty("authorities")
    private Object authorities;

    @JsonProperty("documents")
    private Object documents;

    @JsonProperty("licenses")
    private Object licenses;

    @JsonProperty("finance")
    private Object finance;

    @JsonProperty("address")
    private Address address;
}