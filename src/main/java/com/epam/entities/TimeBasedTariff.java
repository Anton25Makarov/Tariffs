package com.epam.entities;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "time-based-tariff", propOrder = {
        "smsPrice",
        "callPrices"
})
public class TimeBasedTariff extends Tariff {
    @XmlElement(name = "sms-price", namespace = "http://epam.com/tariff", required = true)
    @XmlJavaTypeAdapter(BigDecimalAdaptor.class)
    private BigDecimal smsPrice;
    @XmlElement(name = "call-prices", namespace = "http://epam.com/tariff", required = true)
    private CallPrices callPrices;

    public TimeBasedTariff(String name, OperatorName operatorName, BigDecimal smsPrice, CallPrices callPrices) {
        super(name, operatorName);
        this.smsPrice = smsPrice;
        this.callPrices = callPrices;
    }

    public TimeBasedTariff() {
    }

    public BigDecimal getSmsPrice() {
        return smsPrice;
    }

    public void setSmsPrice(BigDecimal smsPrice) {
        this.smsPrice = smsPrice;
    }


    public CallPrices getCallPrices() {
        return callPrices;
    }

    public void setCallPrices(CallPrices callPrices) {
        this.callPrices = callPrices;
    }

    @Override
    public String toString() {
        return "TimeBasedTariff{" +
                "smsPrice=" + smsPrice +
                ", callPrices=" + callPrices +
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
        TimeBasedTariff that = (TimeBasedTariff) o;
        return Objects.equals(smsPrice, that.smsPrice) &&
                Objects.equals(callPrices, that.callPrices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(smsPrice, callPrices);
    }
}
