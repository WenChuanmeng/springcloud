package com.dd.product.dao;

import com.dd.product.ProductApplicationTests;
import com.dd.product.pojo.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
@Component
public class ProductCategoryRepositoryTest extends ProductApplicationTests {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;
    @Test
    public void findByCategoryType() {
        List<ProductCategory> categories = productCategoryRepository.findByCategoryTypeIn(Arrays.asList(1, 2));
        Assert.assertNotNull(categories);
    }
}