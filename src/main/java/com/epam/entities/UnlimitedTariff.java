package com.epam.entities;

import java.math.BigDecimal;

public class UnlimitedTariff extends Tariff {
    private BigDecimal payroll;

    public UnlimitedTariff(String name, OperatorName operatorName, BigDecimal payroll) {
        super(name, operatorName);
        this.payroll = payroll;
    }

    public BigDecimal getPayroll() {
        return payroll;
    }
}
