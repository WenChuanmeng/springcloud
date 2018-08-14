package com.dd.product.controller;

import com.dd.product.enums.ProductStatusEnum;
import com.dd.product.pojo.ProductCategory;
import com.dd.product.pojo.ProductInfo;
import com.dd.product.service.ProductCategoryService;
import com.dd.product.service.ProductService;
import com.dd.product.utils.ResultVoUtil;
import com.dd.product.vo.ProductCategoryVo;
import com.dd.product.vo.ProductVo;
import com.dd.product.vo.ResultVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductCategoryService  productCategoryService;

    @GetMapping(value = "/list")
    public ResultVo getProductList() {
        /*
        * 1.获取上架的商品
        * 2.获取商品中的类目
        * 3.获取类目信息
        * 4.拼接数据
        * */
        List<ProductInfo> productInfos = productService.getProductInfoByStatusUp(ProductStatusEnum.UP.getCode());

        List<Integer> categoryTypeList = productInfos.stream().map(ProductInfo::getCategoryType).collect(Collectors.toList());

        List<ProductCategory> productCategories = productCategoryService.getCategoryByType(categoryTypeList);

        List<ProductCategoryVo> categoryVos = new ArrayList<>();

        if (productCategories != null && productCategories.size() > 0) {
            for (ProductCategory category  :productCategories) {
                ProductCategoryVo categoryVo = new ProductCategoryVo();
                categoryVo.setCategoryName(category.getCategoryName());
                categoryVo.setCategoryType(category.getCategoryType());

                List<ProductVo> productVos = new ArrayList<>();
                for (ProductInfo productInfo : productInfos) {
                    if (productInfo.getCategoryType().equals(category.getCategoryType())) {
                        ProductVo productVo = new ProductVo();
                        BeanUtils.copyProperties(productInfo, productVo);
                        productVos.add(productVo);
                    }

                }
                categoryVo.setProductVos(productVos);
                categoryVos.add(categoryVo);
            }

        }
        //TODO 哈哈
        return ResultVoUtil.getResult(categoryVos);
    }
}
