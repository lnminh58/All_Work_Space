package com.lnminh.service;

import com.lnminh.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Date;
import java.util.List;

public interface StudentService {
    public List<Student> getAllStudent();

    public List<Student> getStudentsHaveAgeOrNameEqual(int age,String name);

    public List<Student> getStudentsHaveAgeGreaterThanOrBatchNameContain(int age,String pieceBatchName);

    public List<Student> getAllStudentsOrderByAge();

    public List<Student> getStudentsHaveGender(boolean gender);

    public Page<Student> getLimitNumberRow(Pageable pageable);

    public List<Student> findStudentsByCustomField(String columnName, String keyword);

    public List<Student> getStudentsByFullNameNative(String fullName);

    public Student getStudentHighestAge();

    public List<Student> getStudentsByBirthdayLike(Date month);

    public void saveStudent(Student student);
}
