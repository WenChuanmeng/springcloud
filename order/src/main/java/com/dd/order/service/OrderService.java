package com.dd.order.service;

import com.dd.order.dto.OrderDTO;

/**
 * 订单服务
 */
public interface OrderService {

    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);
}
