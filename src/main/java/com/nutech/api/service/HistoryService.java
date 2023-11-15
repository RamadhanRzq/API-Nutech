package com.nutech.api.service;

import com.nutech.api.model.History;
import com.nutech.api.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService {

    private final HistoryRepository historyRepository;

    @Autowired
    public HistoryService(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    public List<History> getTransactionHistory(String email, Integer limit) {
        if (limit != null) {
            return historyRepository.findByEmailOrderByTransactionDateDesc(email);
        } else {
            return historyRepository.findByEmailOrderByTransactionDateDesc(email);
        }
    }
}
