package com.dd.order.controller;

import com.dd.order.convert.OrderForm2OrderDTOConvert;
import com.dd.order.dto.OrderDTO;
import com.dd.order.enums.ResultEnum;
import com.dd.order.exception.OrderException;
import com.dd.order.form.OrderForm;
import com.dd.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;
    /**
     * 1. 参数检验
     * 2. 查询商品信息(调用商品服务)
     * 3. 计算总价
     * 4. 扣库存(调用商品服务)
     * 5. 订单入库
     */
    @RequestMapping(value = "/create")
    public void createOrder(@Valid OrderForm orderForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            log.error("【创建订单】订单form参数不正确，orderForm={}", orderForm);
            throw new OrderException(ResultEnum.PARAMS_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderForm2OrderDTOConvert.convert(orderForm);
        if (orderDTO.getOrderDetails() == null || orderDTO.getOrderDetails().size() <= 0) {
            log.error("【创建订单】购物车为空");
            throw new OrderException(ResultEnum.CARDNULL);
        }

        OrderDTO result = orderService.create(orderDTO);
    }
}
