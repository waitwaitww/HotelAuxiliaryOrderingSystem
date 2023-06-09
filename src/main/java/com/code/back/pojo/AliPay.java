package com.code.back.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AliPay {
    private String traceNo;
    private double totalAmount;
    private String subject;
    private String alipayTraceNo;
}
