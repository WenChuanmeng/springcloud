package com.dd.product.vo;

import lombok.Data;

@Data
public class ResultVo<T> {
    /**
     * 状态码
     */
    private int code;

    /**
     * 说明信息
     */
    private String msg;

    /**
     * 返回数据
     */
    private T data;
}
