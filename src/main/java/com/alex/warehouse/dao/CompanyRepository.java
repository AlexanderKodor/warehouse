package com.alex.warehouse.dao;

import com.alex.warehouse.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
    public List<Company> findAllByAddressCity(String city);
}
