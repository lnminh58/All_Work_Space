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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    BatchService batchService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String showStudents(Model model) {

        List<Batch> batchs = batchService.getAllBatchs();

        Page<Student> studentsPage = studentService.getStudentsLimitNumberRow(new PageRequest(0, 3));


        model.addAttribute("studentPage", studentsPage);
        model.addAttribute("batchs", batchs);

        return "student";
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    @ResponseBody
    public Page<Student> goToPage(@RequestParam(value = "strRequestPageNumber", required = false)
                                              String strRequestPageNumber,
                                  @RequestParam(value = "strCurrentPageNumber", required = false)
                                          String strCurrentPageNumber) {
        System.out.println(strRequestPageNumber);
        System.out.println(strCurrentPageNumber);
        Page<Student> studentPage;
        strRequestPageNumber = strRequestPageNumber.replace("page-", "").trim();
        strCurrentPageNumber = strCurrentPageNumber.replace("page-", "").trim();
        System.out.println(strRequestPageNumber);
        System.out.println(strCurrentPageNumber);
        int currentPageNumber =  Integer.valueOf(strCurrentPageNumber);
        if(strRequestPageNumber.equals("previous")){
            studentPage = studentService.getStudentsLimitNumberRow(new PageRequest(currentPageNumber-2, 3));
        }else if(strRequestPageNumber.equals("next")){
            studentPage =  studentService.getStudentsLimitNumberRow(new PageRequest(currentPageNumber, 3));
        }else{
            int requestPageNumber = Integer.valueOf(strRequestPageNumber.replace("page-", ""));
            studentPage = studentService.getStudentsLimitNumberRow(new PageRequest(requestPageNumber-1, 3));
        }
        return studentPage;
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
