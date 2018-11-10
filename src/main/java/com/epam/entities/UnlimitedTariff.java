package com.epam.entities;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UnlimitedTariff that = (UnlimitedTariff) o;
        return Objects.equals(payroll, that.payroll);
    }

    @Override
    public int hashCode() {
        return Objects.hash(payroll);
    }
}
