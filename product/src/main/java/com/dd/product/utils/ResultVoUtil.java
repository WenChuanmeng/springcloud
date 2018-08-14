package com.dd.product.utils;

import com.dd.product.vo.ResultVo;

public class ResultVoUtil {

    public static ResultVo getResult(Object object) {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(0);
        resultVo.setMsg("success");
        resultVo.setData(object);
        return resultVo;
    }
}
