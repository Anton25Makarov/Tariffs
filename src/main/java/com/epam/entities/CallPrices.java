package com.epam.entities;

import java.math.BigDecimal;

public class CallPrices {
    private BigDecimal priceInsideNetwork;
    private BigDecimal priceOutsideNetwork;
    private BigDecimal priceLandLineNetwork; //on stationary phones

    public CallPrices(BigDecimal priceInsideNetwork, BigDecimal priceOutsideNetwork, BigDecimal priceLandLineNetwork) {
        this.priceInsideNetwork = priceInsideNetwork;
        this.priceOutsideNetwork = priceOutsideNetwork;
        this.priceLandLineNetwork = priceLandLineNetwork;
    }

    public BigDecimal getPriceInsideNetwork() {
        return priceInsideNetwork;
    }

    public BigDecimal getPriceOutsideNetwork() {
        return priceOutsideNetwork;
    }

    public BigDecimal getPriceLandLineNetwork() {
        return priceLandLineNetwork;
    }
}
