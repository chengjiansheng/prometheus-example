package com.cjs.example.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author ChengJianSheng
 * @since 2021/3/8
 */
@Data
public class OrderVO implements Serializable {

    private String orderNo;

    private BigDecimal amount;

    private LocalDateTime createTime;
}
