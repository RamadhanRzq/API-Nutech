package com.nutech.api.repository;

import com.nutech.api.model.History;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface HistoryRepository extends PagingAndSortingRepository<History, Long> {
    List<History> findByEmailOrderByTransactionDateDesc(String email);
}
