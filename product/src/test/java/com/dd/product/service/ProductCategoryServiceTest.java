package com.dd.product.service;

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
public class ProductCategoryServiceTest extends ProductApplicationTests {

    @Autowired
    private ProductCategoryService productCategoryService;

    @Test
    public void getCategoryByType() {
        List<ProductCategory> categories = productCategoryService.getCategoryByType(Arrays.asList(1, 2, 5));
        Assert.assertNotNull("成功",categories);
    }
}