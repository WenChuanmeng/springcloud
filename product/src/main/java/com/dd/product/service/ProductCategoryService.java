package com.dd.product.service;

import com.dd.product.pojo.ProductCategory;

import java.util.List;

public interface ProductCategoryService {

    /**
     * 根据类目的type查找类目的详细信息
     * @param categoryTypeList
     * @return List<ProductCategory>
     */
    List<ProductCategory> getCategoryByType(List<Integer> categoryTypeList);
}
