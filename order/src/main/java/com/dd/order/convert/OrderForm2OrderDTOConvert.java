package com.dd.order.convert;

import com.dd.order.dto.OrderDTO;
import com.dd.order.form.OrderForm;
import com.dd.order.pojo.OrderDetail;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

public class OrderForm2OrderDTOConvert {

    public static OrderDTO convert(OrderForm orderForm) {

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        orderDTO.setBuyerPhone(orderForm.getPhone());

        String items = orderForm.getItems();
        List<OrderDetail> orderDetails = new ArrayList<>();

        if (StringUtils.hasText(items)) {
            Gson gson = new Gson();
            orderDetails = gson.fromJson(items, new TypeToken<List<OrderDetail>>(){}.getType());
        }

        orderDTO.setOrderDetails(orderDetails);
        return orderDTO;
    }
}
