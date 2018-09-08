package com.lnminh.hello.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;


public class LoginAction extends ActionSupport implements SessionAware {
    private String username, message;
    private Map<String, Object> session;


    @Override
    public void setSession(java.util.Map<String, Object> session) {
        this.session= session;
    }

    @Action(value = "/login", results = {
            @Result (name="input", location = "/login.jsp"),
            @Result (name="home", location = "/dashboard.jsp")
    }, interceptorRefs = {
            @InterceptorRef(value = "defaultStack")
    })

    public String login(){
        if(username !=null && username.equals("admin")) {
            session.put("USER", username);
            return "home";
        }
        this.message= "tai khoan "+ this.username +" khong ton tai ";
        return "input";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
