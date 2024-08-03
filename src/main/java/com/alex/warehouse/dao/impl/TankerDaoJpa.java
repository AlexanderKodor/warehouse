package com.alex.warehouse.dao.impl;

import com.alex.warehouse.entity.Tanker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TankerDaoJpa extends JpaRepository<Tanker, Integer> {
}
