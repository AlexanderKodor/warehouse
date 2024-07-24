package com.alex.warehouse.dto.companyFromDadata;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CompanyDtoDadata {
    @JsonProperty("suggestions")
    private List<Suggestion> suggestions;
}
//@Getter
//@Setter
//class Suggestion {
//    @JsonProperty("value")
//    private String value;
//
//    @JsonProperty("unrestricted_value")
//    private String unrestrictedValue;
//
//    @JsonProperty("data")
//    private Data data;
//}
//@Getter
//@Setter
//class Data {
//    @JsonProperty("kpp")
//    private String kpp;
//
//    @JsonProperty("capital")
//    private Object capital;
//
//    @JsonProperty("invalid")
//    private Object invalid;
//
//    @JsonProperty("management")
//    private Management management;
//
//    @JsonProperty("founders")
//    private Object founders;
//
//    @JsonProperty("managers")
//    private Object managers;
//
//    @JsonProperty("predecessors")
//    private Object predecessors;
//
//    @JsonProperty("successors")
//    private Object successors;
//
//    @JsonProperty("branch_type")
//    private String branchType;
//
//    @JsonProperty("branch_count")
//    private int branchCount;
//
//    @JsonProperty("source")
//    private Object source;
//
//    @JsonProperty("qc")
//    private Object qc;
//
//    @JsonProperty("hid")
//    private String hid;
//
//    @JsonProperty("type")
//    private String type;
//
//    @JsonProperty("state")
//    private State state;
//
//    @JsonProperty("opf")
//    private Opf opf;
//
//    @JsonProperty("name")
//    private Name name;
//
//    @JsonProperty("inn")
//    private String inn;
//
//    @JsonProperty("ogrn")
//    private String ogrn;
//
//    @JsonProperty("okpo")
//    private String okpo;
//
//    @JsonProperty("okato")
//    private String okato;
//
//    @JsonProperty("oktmo")
//    private String oktmo;
//
//    @JsonProperty("okogu")
//    private String okogu;
//
//    @JsonProperty("okfs")
//    private String okfs;
//
//    @JsonProperty("okved")
//    private String okved;
//
//    @JsonProperty("okveds")
//    private Object okveds;
//
//    @JsonProperty("authorities")
//    private Object authorities;
//
//    @JsonProperty("documents")
//    private Object documents;
//
//    @JsonProperty("licenses")
//    private Object licenses;
//
//    @JsonProperty("finance")
//    private Object finance;
//
//    @JsonProperty("address")
//    private Address address;
//}
//@Getter
//@Setter
//class Management {
//    @JsonProperty("name")
//    private String name;
//
//    @JsonProperty("post")
//    private String post;
//
//    @JsonProperty("disqualified")
//    private Object disqualified;
//}
//@Getter
//@Setter
//class State {
//    @JsonProperty("status")
//    private String status;
//
//    @JsonProperty("code")
//    private Object code;
//
//    @JsonProperty("actuality_date")
//    private long actualityDate;
//
//    @JsonProperty("registration_date")
//    private long registrationDate;
//
//    @JsonProperty("liquidation_date")
//    private Object liquidationDate;
//}
//@Getter
//@Setter
//class Opf {
//    @JsonProperty("type")
//    private String type;
//
//    @JsonProperty("code")
//    private String code;
//
//    @JsonProperty("full")
//    private String full;
//
//    @JsonProperty("short")
//    private String shortName;
//}
//@Getter
//@Setter
//class Name {
//    @JsonProperty("full_with_opf")
//    private String fullWithOpf;
//
//    @JsonProperty("short_with_opf")
//    private String shortWithOpf;
//
//    @JsonProperty("latin")
//    private Object latin;
//
//    @JsonProperty("full")
//    private String full;
//
//    @JsonProperty("short")
//    private String shortName;
//}
//@Getter
//@Setter
//class Address {
//    @JsonProperty("value")
//    private String value;
//
//    @JsonProperty("unrestricted_value")
//    private String unrestrictedValue;
//
//    @JsonProperty("invalidity")
//    private Object invalidity;
//
//    @JsonProperty("data")
//    private AddressData addressData;
//}
//@Getter
//@Setter
//class AddressData {
//    @JsonProperty("postal_code")
//    private String postalCode;
//
//    @JsonProperty("country")
//    private String country;
//
//    @JsonProperty("country_iso_code")
//    private String countryIsoCode;
//
//    @JsonProperty("federal_district")
//    private String federalDistrict;
//
//    @JsonProperty("region_fias_id")
//    private String regionFiasId;
//
//    @JsonProperty("region_kladr_id")
//    private String regionKladrId;
//
//    @JsonProperty("region_iso_code")
//    private String regionIsoCode;
//
//    @JsonProperty("region_with_type")
//    private String regionWithType;
//
//    @JsonProperty("region_type")
//    private String regionType;
//
//    @JsonProperty("region_type_full")
//    private String regionTypeFull;
//
//    @JsonProperty("region")
//    private String region;
//
//    @JsonProperty("area_fias_id")
//    private Object areaFiasId;
//
//    @JsonProperty("area_kladr_id")
//    private Object areaKladrId;
//
//    @JsonProperty("area_with_type")
//    private Object areaWithType;
//
//    @JsonProperty("area_type")
//    private Object areaType;
//
//    @JsonProperty("area_type_full")
//    private Object areaTypeFull;
//
//    @JsonProperty("area")
//    private Object area;
//
//    @JsonProperty("city_fias_id")
//    private String cityFiasId;
//
//    @JsonProperty("city_kladr_id")
//    private String cityKladrId;
//
//    @JsonProperty("city_with_type")
//    private String cityWithType;
//
//    @JsonProperty("city_type")
//    private String cityType;
//
//    @JsonProperty("city_type_full")
//    private String cityTypeFull;
//
//    @JsonProperty("city")
//    private String city;
//
//    @JsonProperty("city_area")
//    private String cityArea;
//
//    @JsonProperty("city_district_fias_id")
//    private Object cityDistrictFiasId;
//
//    @JsonProperty("city_district_kladr_id")
//    private Object cityDistrictKladrId;
//
//    @JsonProperty("city_district_with_type")
//    private String cityDistrictWithType;
//
//    @JsonProperty("city_district_type")
//    private String cityDistrictType;
//
//    @JsonProperty("city_district_type_full")
//    private String cityDistrictTypeFull;
//
//    @JsonProperty("city_district")
//    private String cityDistrict;
//
//    @JsonProperty("settlement_fias_id")
//    private Object settlementFiasId;
//
//    @JsonProperty("settlement_kladr_id")
//    private Object settlementKladrId;
//
//    @JsonProperty("settlement_with_type")
//    private Object settlementWithType;
//
//    @JsonProperty("settlement_type")
//    private Object settlementType;
//
//    @JsonProperty("settlement_type_full")
//    private Object settlementTypeFull;
//
//    @JsonProperty("settlement")
//    private Object settlement;
//
//    @JsonProperty("street_fias_id")
//    private String streetFiasId;
//
//    @JsonProperty("street_kladr_id")
//    private String streetKladrId;
//
//    @JsonProperty("street_with_type")
//    private String streetWithType;
//
//    @JsonProperty("street_type")
//    private String streetType;
//
//    @JsonProperty("street_type_full")
//    private String streetTypeFull;
//
//    @JsonProperty("street")
//    private String street;
//
//    @JsonProperty("stead_fias_id")
//    private Object steadFiasId;
//
//    @JsonProperty("stead_cadnum")
//    private Object steadCadnum;
//
//    @JsonProperty("stead_type")
//    private Object steadType;
//
//    @JsonProperty("stead_type_full")
//    private Object steadTypeFull;
//
//    @JsonProperty("stead")
//    private Object stead;
//
//    @JsonProperty("house_fias_id")
//    private Object houseFiasId;
//
//    @JsonProperty("house_kladr_id")
//    private Object houseKladrId;
//
//    @JsonProperty("house_cadnum")
//    private Object houseCadnum;
//
//    @JsonProperty("house_flat_count")
//    private Object houseFlatCount;
//
//    @JsonProperty("house_type")
//    private String houseType;
//
//    @JsonProperty("house_type_full")
//    private String houseTypeFull;
//
//    @JsonProperty("house")
//    private String house;
//
//    @JsonProperty("block_type")
//    private Object blockType;
//
//    @JsonProperty("block_type_full")
//    private Object blockTypeFull;
//
//    @JsonProperty("block")
//    private Object block;
//
//    @JsonProperty("entrance")
//    private Object entrance;
//
//    @JsonProperty("floor")
//    private Object floor;
//
//    @JsonProperty("flat_fias_id")
//    private Object flatFiasId;
//
//    @JsonProperty("flat_cadnum")
//    private Object flatCadnum;
//
//    @JsonProperty("flat_type")
//    private Object flatType;
//
//    @JsonProperty("flat_type_full")
//    private Object flatTypeFull;
//
//    @JsonProperty("flat")
//    private Object flat;
//
//    @JsonProperty("flat_area")
//    private String flatArea;
//
//    @JsonProperty("square_meter_price")
//    private String squareMeterPrice;
//
//    @JsonProperty("flat_price")
//    private Object flatPrice;
//
//    @JsonProperty("room_fias_id")
//    private Object roomFiasId;
//
//    @JsonProperty("room_cadnum")
//    private Object roomCadnum;
//
//    @JsonProperty("room_type")
//    private Object roomType;
//
//    @JsonProperty("room_type_full")
//    private Object roomTypeFull;
//
//    @JsonProperty("room")
//    private Object room;
//
//    @JsonProperty("postal_box")
//    private Object postalBox;
//
//    @JsonProperty("fias_id")
//    private String fiasId;
//
//    @JsonProperty("fias_code")
//    private String fiasCode;
//
//    @JsonProperty("fias_level")
//    private String fiasLevel;
//
//    @JsonProperty("fias_actuality_state")
//    private String fiasActualityState;
//
//    @JsonProperty("kladr_id")
//    private String kladrId;
//
//    @JsonProperty("geoname_id")
//    private Integer geonameId;
//
//    @JsonProperty("capital_marker")
//    private String capitalMarker;
//
//    @JsonProperty("okato")
//    private String okato;
//
//    @JsonProperty("oktmo")
//    private String oktmo;
//
//    @JsonProperty("tax_office")
//    private String taxOffice;
//
//    @JsonProperty("tax_office_legal")
//    private String taxOfficeLegal;
//
//    @JsonProperty("timezone")
//    private String timezone;
//
//    @JsonProperty("geo_lat")
//    private String geoLat;
//
//    @JsonProperty("geo_lon")
//    private String geoLon;
//
//    @JsonProperty("beltway_hit")
//    private String beltwayHit;
//
//    @JsonProperty("beltway_distance")
//    private Object beltwayDistance;
//
//    @JsonProperty("metro")
//    private List<Metro> metro;
//
//    @JsonProperty("divisions")
//    private Object divisions;
//
//    @JsonProperty("qc_geo")
//    private String qcGeo;
//
//    @JsonProperty("qc_complete")
//    private Object qcComplete;
//
//    @JsonProperty("qc_house")
//    private Object qcHouse;
//
//    @JsonProperty("history_values")
//    private Object historyValues;
//
//    @JsonProperty("unparsed_parts")
//    private Object unparsedParts;
//
//    @JsonProperty("source")
//    private String source;
//
//    @JsonProperty("qc")
//    private String qc;
//}
//@Getter
//@Setter
//class Metro {
//    @JsonProperty("name")
//    private String name;
//
//    @JsonProperty("line")
//    private String line;
//
//    @JsonProperty("distance")
//    private double distance;
//}