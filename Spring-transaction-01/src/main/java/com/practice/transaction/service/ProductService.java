package com.practice.transaction.service;

import com.practice.transaction.dao.ProductDao;
import com.practice.transaction.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductDao  productDao;

    @Transactional
   public void saveProductInfo(){
        Product product=new Product();
        for(int i=1;i<=10;i++){
            product.setId(i);
            product.setName("testing product "+i);
            productDao.saveProduct(product);
            if(i==8){
                throw  new RuntimeException("error occcured");
            }
        }
    }
}
