package com.lnminh.service;

import com.lnminh.entity.Batch;

import java.util.List;

public interface BatchService {

    public List<Batch> getAllBatchs();

    public List<Batch> getBatchByBatchName(String batchName);

    public Batch getBatchByBatchId(int batchId);

    public void deleteBatch(Batch batch);
}