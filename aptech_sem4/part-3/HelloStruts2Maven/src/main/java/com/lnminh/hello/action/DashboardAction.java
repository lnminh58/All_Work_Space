package com.lnminh.hello.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;

public class DashboardAction extends ActionSupport {
    @Action(value = "/home", results = {
            @Result(name = "success", location = "/dashboard.jsp")
    }, interceptorRefs = {
            @InterceptorRef(value = "authStack")
    })
    public String home(){
        return "success";
    }
}
