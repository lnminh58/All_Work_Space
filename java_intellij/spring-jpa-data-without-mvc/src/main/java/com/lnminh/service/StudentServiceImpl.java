package com.lnminh.service;

import com.lnminh.dao.StudentRepository;
import com.lnminh.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getStudentsHaveAgeOrNameEqual(int age, String name) {
        return studentRepository.findDistinctByAgeOrFullName(age,name);
    }

    @Override
    public List<Student> getStudentsHaveAgeGreaterThanOrBatchNameContain(int age, String pieceBatchName) {
        return studentRepository.findDistinctByAgeGreaterThanOrBatch_BatchNameContaining(age,pieceBatchName);
    }

    @Override
    public List<Student> getAllStudentsOrderByAge() {
        return studentRepository.findAllByOrderByAge();
    }

    @Override
    public List<Student> getStudentsHaveGender(boolean gender) {
        return studentRepository.findByOverGender(gender);
    }

    @Override
    public Page<Student> getLimitNumberRow(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public List<Student> findStudentsByCustomField(String columnName, String keyword) {
//        return studentRepository.findLikeMultiField(columnName,keyword);
        return new ArrayList<>();
    }

    @Override
    public List<Student> getStudentsByFullNameNative(String fullName) {
        return studentRepository.findByFullNameNative(fullName);
    }


}
