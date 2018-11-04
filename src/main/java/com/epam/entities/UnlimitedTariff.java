package com.epam.entities;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;

//@XmlSeeAlso({Tariff.class})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "unlimited-tariff", propOrder = {
        "payroll"
})
@XmlSeeAlso({
        BigDecimal.class,
})
public class UnlimitedTariff extends Tariff {
    @XmlElement(name = "payroll", namespace = "http://epam.com/tariff", required = true)
    @XmlJavaTypeAdapter(BigDecimalAdaptor.class)
    private BigDecimal payroll;

    public UnlimitedTariff(String name, OperatorName operatorName, BigDecimal payroll) {
        super(name, operatorName);
        this.payroll = payroll;
    }

    public UnlimitedTariff() {
    }

    public BigDecimal getPayroll() {
        return payroll;
    }

    public void setPayroll(BigDecimal payroll) {
        this.payroll = payroll;
    }

    @Override
    public String toString() {
        return "UnlimitedTariff{" +
                "payroll=" + payroll +
                '}';
    }
}
