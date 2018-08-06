package com.aptech.webent.service;

import com.aptech.webent.model.Product;

import java.util.List;

public class ListProductsToString {
    public static String convertToString(List<Product> list){
        String strList="";
        for (Product product:list) {
            strList+= product.toString()+"'";
        }
        return strList;
    }
}
