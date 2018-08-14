package com.dd.product.service;

import com.dd.product.ProductApplicationTests;
import com.dd.product.pojo.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.junit.Assert.*;
@Component
public class ProductServiceTest extends ProductApplicationTests {

    @Autowired
    private ProductService productService;

    @Test
    public void getProductInfoByStatusUp() {
        List<ProductInfo> productInfos = productService.getProductInfoByStatusUp(0);
        Assert.assertNotNull(productInfos.size() > 0);
    }
}