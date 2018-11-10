package com.epam.entities;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.math.BigDecimal;

public class BigDecimalAdaptor extends XmlAdapter<String, BigDecimal> {


    @Override
    public BigDecimal unmarshal(String v) {
        return new BigDecimal(v).setScale(2, BigDecimal.ROUND_HALF_DOWN);
    }

    @Override
    public String marshal(BigDecimal v) {
        return String.valueOf(v);
    }
}
