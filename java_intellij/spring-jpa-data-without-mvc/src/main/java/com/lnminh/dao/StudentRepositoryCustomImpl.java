package com.lnminh.dao;

import com.lnminh.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
@Repository
public class StudentRepositoryCustomImpl implements StudentRepositoryCustom {
    @Autowired
    EntityManager entityManager;

    @Override
    public List<Student> findLikeMultiField(String fieldName, String keyword) {
        String sql = "select s from Student s where s."+fieldName+" like '%"+ keyword+"%'";
        Query query = entityManager.createQuery(sql);
        List<Student> list = query.getResultList();
        return list;
    }
}
