package com.alex.warehouse.controller;

import com.alex.warehouse.communicator.CommunicationDadata;
import com.alex.warehouse.dto.companyFromDadata.RequestCompany;
import com.alex.warehouse.entity.Company;
import com.alex.warehouse.exception_handling.HandlingData;
import com.alex.warehouse.exception_handling.NoSuchDataException;
import com.alex.warehouse.mapping.CompanyDadataMap;
import com.alex.warehouse.service.impl.CompanyServiseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CompanyRestController {
    CompanyServiseImpl companyService;
    CommunicationDadata communicationDadata;

    public CompanyRestController(CompanyServiseImpl companyService, CommunicationDadata communicationDadata) {
        this.companyService = companyService;
        this.communicationDadata = communicationDadata;
    }

    @GetMapping("/company")
    public List<Company> showAllEntity() {
        List<Company> companyList = companyService.getAllEntity();
        if (companyList.size() == 0) {
            throw new NoSuchDataException("Информация по данному запросу отсутсвует.");
        }
        return companyList;
    }

    @GetMapping("/company/search")
    public Company showEntity(@RequestParam("id") int id) {
        Company company = companyService.getEntity(id);
        if (company == null) {
            throw new NoSuchDataException("Контрагент с id - " + id + " отсутствует.");
        }
        return company;
    }

    @PostMapping("/company/search")
    public List<Company> findEntity(@RequestBody Company company){
        return companyService.dynamicFilter(company);
    }

    @PostMapping("/company")
    public Company saveEntity(@RequestBody Company company){
        return companyService.saveEntity(company);
    }
    @PostMapping("/company/autocompleteDadata")
    public Company autocompleteDadata(@RequestBody RequestCompany requestCompany){
        Company company = CompanyDadataMap.mapping(communicationDadata.getInfo(requestCompany));
        company = companyService.saveEntity(company);
        return company;
    }

    @PutMapping("/company")
    public Company updateEntity(@RequestBody Company company){
        return companyService.saveEntity(company);
    }

    @DeleteMapping("/company")
    public HandlingData deleteEntity(@RequestParam("id") int id){
        Company company = companyService.getEntity(id);
        if (company == null) {
            throw new NoSuchDataException("Контрагент с id - " + id + " отсутствует.");
        }
        companyService.deleteEntity(id);
        return new HandlingData("Контрагент с id - " + id + " удалён.");
    }
}
