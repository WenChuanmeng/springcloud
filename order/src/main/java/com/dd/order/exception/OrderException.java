package com.dd.order.exception;

import com.dd.order.enums.ResultEnum;

public class OrderException extends RuntimeException {

    private Integer code;

    private String msg;

    public OrderException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
}
