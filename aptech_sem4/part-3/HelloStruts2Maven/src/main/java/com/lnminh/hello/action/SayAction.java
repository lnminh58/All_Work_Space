package com.lnminh.hello.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;

public class SayAction extends ActionSupport {
    @Action(value = "/say", results = {
            @Result(name = "say", location = "/say.jsp")
    }, interceptorRefs = {
            @InterceptorRef(value = "logStack")
    })
    public String say() {
        this.message = "say hello " + this.name;
        return "say";
    }
    private String name;
    private String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}