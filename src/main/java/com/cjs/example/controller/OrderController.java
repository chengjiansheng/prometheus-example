package com.cjs.example.controller;

import com.cjs.example.domain.OrderDTO;
import com.cjs.example.domain.OrderVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author ChengJianSheng
 * @since 2021/3/8
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @PostMapping("/createOrder")
    public OrderVO createOrder(@RequestBody OrderDTO orderDTO) {
        OrderVO vo = new OrderVO();
        vo.setOrderNo("1234");
        vo.setAmount(orderDTO.getAmount());
        vo.setCreateTime(LocalDateTime.now());
        return vo;
    }
}
