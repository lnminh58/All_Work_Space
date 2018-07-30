package com.lnminh.service.helper;

import com.lnminh.entity.Student;
import com.lnminh.model.StudentVO;

import java.util.Random;

public class Converter {
    public static Student convertStudentVOToStudent(StudentVO studentVO){
        Student student = new Student();
        student.setAge(20+(new Random().nextInt(10)));
        student.setFullName(studentVO.getFullName());
        student.setGender(studentVO.isGender());
        student.setBirthday(studentVO.getBirthday());
        return student;
    }
}
