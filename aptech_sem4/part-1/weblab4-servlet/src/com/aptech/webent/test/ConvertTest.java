package com.aptech.webent.test;

import com.aptech.webent.model.Product;
import com.aptech.webent.service.ListProductsToString;
import com.aptech.webent.service.StringToListProduct;

import java.util.ArrayList;
import java.util.List;

public class ConvertTest {
    public static void main(String[] args) {
        List<Product> products= new ArrayList<>();
        System.out.println(products.size());
        products.add(new Product("Tao",1));
        products.add(new Product("Xoai",2));
        products.add(new Product("Man",3));

        String strListProducts = ListProductsToString.convertToString(products);
        System.out.println(strListProducts);

        List<Product> listProducts = StringToListProduct.convertToListProducts
                (strListProducts);
        for (Product product: listProducts) {
            System.out.println(product.getProductName()+"\t" + product.getQuantity());
        }

    }
}
