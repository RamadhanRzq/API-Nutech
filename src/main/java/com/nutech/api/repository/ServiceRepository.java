package com.nutech.api.repository;

import com.nutech.api.model.Service;
import org.springframework.data.repository.CrudRepository;

public interface ServiceRepository extends CrudRepository<Service, Integer> {
    Service findByServiceCode(String serviceCode);
}
