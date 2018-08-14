package com.dd.order.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class OrderForm {

    @NotEmpty(message = "买家姓名不能为空")
    private String name;

    @NotEmpty(message = "买家手机号不能为空")
    private String phone;

    @NotEmpty(message = "买家地址不能为空")
    private String address;

    @NotEmpty(message = "买家openid不能为空")
    private String openid;

    @NotEmpty(message = "订单详情不能为空")
    private String items;
}
