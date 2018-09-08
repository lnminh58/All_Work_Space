package com.lnminh.hello.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

public class RegisterAction  extends ActionSupport {
    private String country;
    private String message;
    private String countries[] = {
            "Vietname", "laos", "Singafore", "HongKong","Japan"
    };

    @Action(value = "/register", results = {
            @Result(name = "success", location = "/register.jsp")
    })
    public String register(){
        if(!(country == null) && !country.equals("") )
        message = "Selected country: " + country;
        return "success";
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String[] getCountries() {
        return countries;
    }

    public void setCountries(String[] countries) {
        this.countries = countries;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}


