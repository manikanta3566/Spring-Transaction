package com.practice.transaction.dao;

import com.practice.transaction.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void saveProduct(Product product){
        String insertQuery="INSERT INTO PRODUCT VALUES(?,?)";
        int insertedRows = jdbcTemplate.update(insertQuery, new Object[]{product.getId(), product.getName()});
        System.out.println("product inserted "+insertedRows);
    }
}
