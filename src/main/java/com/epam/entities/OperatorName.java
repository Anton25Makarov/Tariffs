package com.epam.entities;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "operator-name", namespace = "http://epam.com/tariff")
@XmlEnum
public enum OperatorName {
    VELCOM,
    LIFE,
    MTS;

    public static OperatorName fromValue(String v) {
        return valueOf(v);
    }

    public String value() {
        return name();
    }
}
