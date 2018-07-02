package com.lnminh.dao;

import com.lnminh.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    public List<Student> findDistinctByAgeOrFullName(int a, String name);

    public List<Student> findDistinctByAgeGreaterThanOrBatch_BatchNameContaining(int age,String pieceBatchName);

    public List<Student> findAllByOrderByAge();

    public List<Student> findByOverGender(boolean gender);

    @Query(name = "Select * form student where ?1 like '%?2'", nativeQuery = true)
    public List<Student> findAbstractField(String columnName, String keyword);

}
