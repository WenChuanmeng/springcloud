package com.dd.product.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductVo {

    @JsonProperty(value = "id")
    private String productId;

    @JsonProperty(value = "name")
    private String productName;

    @JsonProperty(value = "price")
    private BigDecimal productPrice;

    @JsonProperty(value = "description")
    private String productDescription;

    @JsonProperty(value = "icon")
    private String productIcon;
}
