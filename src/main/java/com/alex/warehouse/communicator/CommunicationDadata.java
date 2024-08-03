package com.alex.warehouse.communicator;

import com.alex.warehouse.dto.companyFromDadata.CompanyDtoDadata;
import com.alex.warehouse.dto.companyFromDadata.RequestCompany;
import com.alex.warehouse.exception_handling.NoSuchDataException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class CommunicationDadata {
    @Value("${dadata.url}")
    private String URL;
    @Value("${dadata.token}")
    private String Token;
    private RestTemplate restTemplate;

    public CommunicationDadata(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CompanyDtoDadata getInfo(RequestCompany requestCompany){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.set("Authorization", Token);
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
