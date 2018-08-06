package com.lnminh.repository;

import com.lnminh.entity.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
//@Repository
public interface BatchRepository extends JpaRepository<Batch,Integer> {

}
