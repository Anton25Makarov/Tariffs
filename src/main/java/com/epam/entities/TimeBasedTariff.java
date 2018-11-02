package com.epam.entities;

import java.math.BigDecimal;

public class TimeBasedTariff extends Tariff {
    private BigDecimal smsPrice;
    private CallPrices callPrices;

    public TimeBasedTariff(String name, OperatorName operatorName, BigDecimal smsPrice, CallPrices callPrices) {
        super(name, operatorName);
        this.smsPrice = smsPrice;
        this.callPrices = callPrices;
    }

    public BigDecimal getSmsPrice() {
        return smsPrice;
    }

    public CallPrices getCallPrices() {
        return callPrices;
    }
}
