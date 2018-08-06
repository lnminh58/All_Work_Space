package com.aptech.webent.service;

import com.aptech.webent.model.Product;

import java.util.ArrayList;
import java.util.List;

public class StringToListProduct {
    public static List<Product> convertToListProducts(String strListProducts){
        List<Product> products = new ArrayList<>();
        String[] strProducts = strListProducts.split("'");
        if (strListProducts.length()>0){
            for (String strProduct:strProducts) {
                String[] product = strProduct.split(";");
                if(product.length==2){
                    products.add(new Product(product[0],Integer.valueOf(product[1])));
                }
          }
        }
        return products;
    }
}
