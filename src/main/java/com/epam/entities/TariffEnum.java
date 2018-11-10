package com.epam.entities;

public enum TariffEnum {

    NAME("name"),
    OPERATOR_NAME("operator-name"),
    CALL_PRICES("call-prices"),
    SMS_PRICE("sms_price"),
    PRICE_INSIDE_NETWORK("price-inside-network"),
    PRICE_OUTSIDE_NETWORK("price-outside-network"),
    PRICE_LANDLINES_NETWORK("price-landlines-network"),
    PAYROLL("payroll");

    private String value;

    TariffEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
