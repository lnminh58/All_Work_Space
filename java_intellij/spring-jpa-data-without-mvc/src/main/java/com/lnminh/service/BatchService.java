package com.lnminh.service;

import com.lnminh.entity.Batch;

import java.util.List;
import java.util.Optional;

public interface BatchService {

    public List<Batch> getAllBatchs();

    public List<Batch> getBatchByBatchName(String batchName);

}