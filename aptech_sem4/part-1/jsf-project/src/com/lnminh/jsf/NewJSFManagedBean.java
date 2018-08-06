package com.lnminh.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "RegistrationManagedBean",eager = true)
@RequestScoped
public class NewJSFManagedBean {

    @ManagedProperty(value = "#{prefix}")
    private String prefix;

    @ManagedProperty(value = "#{name}")
    private String name;

    @ManagedProperty(value = "#{age}")
    private int age;

    @ManagedProperty(value = "#{contactno}")
    private String contactno;


}
