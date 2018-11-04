package com.epam.entities;

public enum TariffEnum {

    NAME("name"),
    OPERATOR_NAME("operator-name"),
    SMS_PRICE("sms-price"),
    CALL_PRICES("call-prices"),
    PRICE_INSIDE_NETWORK("price-inside-network"),
    PRICE_OUTSUDE_NETWORK("price-outside-network"),
    PRICE_LAND_LINE_NETWORK("price-landlines-network");

    private String value;

    private TariffEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
