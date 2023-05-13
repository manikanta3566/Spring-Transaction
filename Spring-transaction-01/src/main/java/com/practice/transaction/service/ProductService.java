package com.practice.transaction.service;

import com.practice.transaction.dao.ProductDao;
import com.practice.transaction.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductDao  productDao;

   public void saveProductInfo(){
        Product product=new Product();
        for(int i=1;i<=10;i++){
            product.setId(i);
            product.setName("testing product "+i);
            productDao.saveProduct(product);
        }
    }
}
