package com.jfreedom.service;

import com.jfreedom.model.Custommer;
import com.jfreedom.model.Shop;
import com.jfreedom.reponsitory.CustomerJPAReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by PC-PC on 9/8/2016.
 */
@Service
public class CusServiceImpl implements CustomerService {
    @Autowired
    CustomerJPAReponsitory customerJPAReponsitory;
    public Custommer findOneid(){

        return  customerJPAReponsitory.findOne(1);
    }
    public List<Custommer> findBycusName( String cusName){
        return customerJPAReponsitory.findBycusName(cusName);
    }
}
