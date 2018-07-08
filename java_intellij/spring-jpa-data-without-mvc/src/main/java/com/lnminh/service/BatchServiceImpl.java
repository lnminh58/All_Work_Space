package com.lnminh.service;

import com.lnminh.dao.BatchReposity;
import com.lnminh.entity.Batch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatchServiceImpl implements BatchService {

    @Autowired
    BatchReposity batchReposity;


    @Override
    public List<Batch> getAllBatchs() {
        return batchReposity.findAll();
    }

    @Override
    public List<Batch> getBatchByBatchName(String batchName) {
        return batchReposity.findByBatchName(batchName);
    }

}
