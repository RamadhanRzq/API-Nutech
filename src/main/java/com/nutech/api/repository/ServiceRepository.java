package com.nutech.api.repository;

import com.nutech.api.model.Service;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ServiceRepository extends CrudRepository<Service, Integer> {
    @Query("SELECT s FROM Service s WHERE s.service_code = :service_code")
    Service findByService_code(@Param("service_code") String service_code);
}
