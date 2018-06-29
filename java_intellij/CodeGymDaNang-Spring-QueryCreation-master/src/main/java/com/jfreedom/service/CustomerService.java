package com.jfreedom.service;

import com.jfreedom.model.Custommer;

import java.util.List;

/**
 * Created by PC-PC on 9/8/2016.
 */
public interface CustomerService  {
    Custommer findOneid();
    List<Custommer> findBycusName(String cusName);
}
