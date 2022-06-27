package com.code.back.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AliPay {
    private String subject;
    private String traceNo;
    private String totalAmount;
}
