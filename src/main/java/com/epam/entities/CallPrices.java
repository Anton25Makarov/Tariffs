package com.epam.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "call-prices", namespace = "http://epam.com/tariff", propOrder = {
        "priceInsideNetwork",
        "priceOutsideNetwork",
        "priceLandLinesNetwork"
})
public class CallPrices {
    @XmlElement(name = "price-inside-network", namespace = "http://epam.com/tariff", required = true)
    @XmlJavaTypeAdapter(BigDecimalAdaptor.class)
    private BigDecimal priceInsideNetwork;
    @XmlElement(name = "price-outside-network", namespace = "http://epam.com/tariff", required = true)
    @XmlJavaTypeAdapter(BigDecimalAdaptor.class)
    private BigDecimal priceOutsideNetwork;
    @XmlElement(name = "price-landlines-network", namespace = "http://epam.com/tariff", required = true)
    @XmlJavaTypeAdapter(BigDecimalAdaptor.class)
    private BigDecimal priceLandLinesNetwork; //on stationary phones

    public CallPrices() {
    }

    public CallPrices(BigDecimal priceInsideNetwork, BigDecimal priceOutsideNetwork, BigDecimal priceLandLinesNetwork) {
        this.priceInsideNetwork = priceInsideNetwork;
        this.priceOutsideNetwork = priceOutsideNetwork;
        this.priceLandLinesNetwork = priceLandLinesNetwork;
    }

    public BigDecimal getPriceInsideNetwork() {
        return priceInsideNetwork;
    }

    public void setPriceInsideNetwork(BigDecimal priceInsideNetwork) {
        this.priceInsideNetwork = priceInsideNetwork;
    }

    public BigDecimal getPriceOutsideNetwork() {
        return priceOutsideNetwork;
    }

    public void setPriceOutsideNetwork(BigDecimal priceOutsideNetwork) {
        this.priceOutsideNetwork = priceOutsideNetwork;
    }

    public BigDecimal getPriceLandLinesNetwork() {
        return priceLandLinesNetwork;
    }

    public void setPriceLandLinesNetwork(BigDecimal priceLandLinesNetwork) {
        this.priceLandLinesNetwork = priceLandLinesNetwork;
    }

    @Override
    public String toString() {
        return "CallPrices{" +
                "priceInsideNetwork=" + priceInsideNetwork +
                ", priceOutsideNetwork=" + priceOutsideNetwork +
                ", priceLandLinesNetwork=" + priceLandLinesNetwork +
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
        CallPrices that = (CallPrices) o;
        return Objects.equals(priceInsideNetwork, that.priceInsideNetwork) &&
                Objects.equals(priceOutsideNetwork, that.priceOutsideNetwork) &&
                Objects.equals(priceLandLinesNetwork, that.priceLandLinesNetwork);
    }

    @Override
    public int hashCode() {
        return Objects.hash(priceInsideNetwork, priceOutsideNetwork, priceLandLinesNetwork);
    }
}
