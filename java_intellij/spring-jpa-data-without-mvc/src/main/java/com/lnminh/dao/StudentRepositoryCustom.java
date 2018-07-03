package com.lnminh.dao;

import com.lnminh.entity.Student;

import java.util.List;

public interface StudentRepositoryCustom {
    public List findLikeMultiField(String columnName,String keyword);
}
