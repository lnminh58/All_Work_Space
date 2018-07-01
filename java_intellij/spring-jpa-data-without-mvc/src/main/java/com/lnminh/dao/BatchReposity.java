package com.lnminh.dao;

import com.lnminh.entity.Batch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BatchReposity extends JpaRepository<Batch,Integer> {
    public List<Batch> findByBatchName(String batchName);
}
