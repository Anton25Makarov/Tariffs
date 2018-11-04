package com.epam.entities;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.math.BigDecimal;

public class BigDecimalAdaptor extends XmlAdapter<String, BigDecimal> {


    @Override
    public BigDecimal unmarshal(String v) throws Exception {
        return new BigDecimal(v).setScale(2);
    }

    @Override
    public String marshal(BigDecimal v) throws Exception {
        return null;
    }
}
