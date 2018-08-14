package com.dd.product.service.impl;

import com.dd.product.dao.ProductInfoRepository;
import com.dd.product.pojo.ProductInfo;
import com.dd.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> getProductInfoByStatusUp(Integer code) {

        return productInfoRepository.findByProductStatus(code);
    }
}
