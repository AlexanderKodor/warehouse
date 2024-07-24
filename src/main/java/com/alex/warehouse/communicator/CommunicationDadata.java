package com.alex.warehouse.communicator;

import com.alex.warehouse.dto.companyFromDadata.CompanyDtoDadata;
import com.alex.warehouse.dto.companyFromDadata.RequestCompany;
import com.alex.warehouse.exception_handling.NoSuchDataException;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class CommunicationDadata {
    private static RestTemplate restTemplate;
    private final static String URL = "http://suggestions.dadata.ru/suggestions/api/4_1/rs/findById/party";

    public CompanyDtoDadata getInfo(RequestCompany requestCompany){
        restTemplate  =new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.set("Authorization", "Token 0d079eac4036613ccacdfe6d5a6c2ef25d70737b");
        httpHeaders.set("Accept", "application/json");
        httpHeaders.add ("User-Agent", "PostmanRuntime/7.35.0");
        HttpEntity httpEntity = new HttpEntity(requestCompany,httpHeaders);
        ResponseEntity<CompanyDtoDadata> responseEntity = null;
        try {
            responseEntity = restTemplate.exchange(URL, HttpMethod.POST, httpEntity, CompanyDtoDadata.class);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            throw new NoSuchDataException("Запрос к сервису Dadata оказался неуспешен.");
        }
        if(responseEntity.getStatusCode()!=HttpStatusCode.valueOf(200)){
            throw new NoSuchDataException("Запрос к сервису Dadata пришёл со статусом: " + responseEntity.getStatusCode());
        }
        return responseEntity.getBody();
    }
}
