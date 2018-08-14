package com.dd.product.service;

import com.dd.product.pojo.ProductInfo;

import java.util.List;

public interface ProductService {
    /**
     * 根据商品的状态获取商品信息
     * @param code
     * @return List<ProductInfo>
     */
    List<ProductInfo> getProductInfoByStatusUp(Integer code);
}
