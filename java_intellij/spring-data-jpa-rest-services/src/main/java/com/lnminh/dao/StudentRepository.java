package com.lnminh.dao;

import com.lnminh.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    public List<Student> findDistinctByAgeOrFullName(int a, String name);

    public List<Student> findDistinctByAgeGreaterThanOrBatch_BatchNameContaining(int age, String pieceBatchName);

    public List<Student> findAllByOrderByAgeAsc();

    public List<Student> findByOverGender(boolean gender);

    public Student findTopByOrderByAgeDesc();

    public List<Student> findByBirthdayContaining(Date month);
//    @Query(value = "Select s from  student s where s.:name_column like %:keyword%")
//    public List<Student> findLikeMultiField(String columnName,String keyword);


    @Query(value = "Select * from student  where full_name like %?1%", nativeQuery = true)
    public List<Student> findByFullNameNative(String fullName);


}
