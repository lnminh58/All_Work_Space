package com.lnminh.service;

import com.lnminh.entity.Batch;
import com.lnminh.repository.BatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BatchManagerImpl implements BatchManager {

    @Autowired
    BatchRepository batchRepository;

    @Override
    public List<Batch> getAllBatchs() {
        return batchRepository.findAll();
    }
}
