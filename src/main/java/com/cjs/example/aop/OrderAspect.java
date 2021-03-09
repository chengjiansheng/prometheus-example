package com.cjs.example.aop;

import com.cjs.example.domain.OrderVO;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.DistributionSummary;
import io.micrometer.core.instrument.MeterRegistry;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author ChengJianSheng
 * @since 2021/3/8
 */
@Aspect
@Component
public class OrderAspect {

    private Counter orderCounter;

    private DistributionSummary orderSummary;

    public OrderAspect(MeterRegistry registry) {
        orderCounter = registry.counter("order_quantity_total", "status", "success");
        orderSummary = registry.summary("order_amount_total", "status", "success");
    }

//    @PostConstruct
//    public void init() {
//
//    }


    @Pointcut("execution(public * com.cjs.example.controller.OrderController.createOrder(..))")
    public void pointcut() {

    }

    @Around("pointcut()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        Object result = pjp.proceed();
        OrderVO orderVO = (OrderVO) result;

        orderCounter.increment();
        orderSummary.record(orderVO.getAmount().doubleValue());

        return result;
    }

}
