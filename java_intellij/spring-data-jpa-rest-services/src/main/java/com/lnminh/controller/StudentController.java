package com.lnminh.controller;

import com.lnminh.entity.Batch;
import com.lnminh.entity.Student;
import com.lnminh.model.StudentVO;
import com.lnminh.service.BatchService;
import com.lnminh.service.StudentService;
import com.lnminh.service.helper.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @Autowired
    BatchService batchService;

    @RequestMapping(value = "/get-students", method = RequestMethod.GET)
    @ResponseBody
    public Page<Student> showStudents(@RequestParam(value = "page", required = true) int pageNumber, @RequestParam
            (value = "quantity", required = true) int quantity) {
        List<Batch> batchs = batchService.getAllBatchs();
        Page<Student> studentsPage = studentService.getStudentsLimitNumberRow(new PageRequest(pageNumber, quantity));
        return studentsPage;
    }

    @RequestMapping(value = "/get-batchs", method = RequestMethod.GET)
    @ResponseBody
    public List<Batch> showBatchs() {
        List<Batch> batchs = batchService.getAllBatchs();
        return batchs;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Student addPerson(@RequestBody StudentVO studentVO) {
        Student student = Converter.convertStudentVOToStudent(studentVO);
        Batch batch = batchService.getBatchByBatchId(studentVO.getBatchId());
        student.setBatch(batch);
        Student studentComeBack = studentService.saveStudent(student);
        return studentComeBack;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public void deletePerson(@RequestBody Map<String, String> id) {
        studentService.deleteStudent(Integer.parseInt(id.get("id")));
    }

}
