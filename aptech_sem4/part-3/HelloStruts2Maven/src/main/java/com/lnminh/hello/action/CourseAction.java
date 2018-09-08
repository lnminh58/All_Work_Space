package com.lnminh.hello.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class CourseAction extends ActionSupport {
    private String category;
    private String categories[] = {
            "Java", "C#", "C++", "PHP","Javascript"
    };
    private String courseId;
    private String name;
    private String description;
    private String message;

    @Action(value = "/course", results = {
            @Result(name = "success", location = "/course.jsp")
    })
    public String course(){
        this.message=null;
        return "success";
    }

    @Action(value = "/new", results = {
            @Result(name = "success", location = "/course.jsp")
    })
    public String newCourse(){
        this.category="";
        this.courseId="";
        this.name="";
        this.description="";
        this.message="create new";
        return "success";
    }
    @Action(value = "/save", results = {
            @Result(name = "success", location = "/course.jsp")
    })
    public String saveCourse(){

        try {
            FileOutputStream fos = new FileOutputStream("course.txt",true);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.newLine();
            bw.write(this.category);
            bw.newLine();
            bw.write(this.courseId);
            bw.newLine();
            bw.write(this.name);
            bw.newLine();
            bw.write(this.description);
            bw.newLine();
            bw.close();
            osw.close();
            fos.close();
            this.message="save success";

        }catch (Exception ex) {
            System.out.println(ex.getMessage());
            this.message = "save fail";
        }
        return "success";
    }


    public String getCategory() {
        return category;

    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String[] getCategories() {
        return categories;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
