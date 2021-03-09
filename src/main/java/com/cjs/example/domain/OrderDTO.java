package com.cjs.example.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author ChengJianSheng
 * @since 2021/3/8
 */
@Data
public class OrderDTO implements Serializable {

    /**
     * 订单金额
     */
    private BigDecimal amount;
}
