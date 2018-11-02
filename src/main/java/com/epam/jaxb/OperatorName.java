
package com.epam.jaxb;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OperatorName.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="OperatorName">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="VELCOM"/>
 *     &lt;enumeration value="MTS"/>
 *     &lt;enumeration value="LIFE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "OperatorName", namespace = "com.epam.entities")
@XmlEnum
public enum OperatorName {

    VELCOM,
    MTS,
    LIFE;

    public String value() {
        return name();
    }

    public static OperatorName fromValue(String v) {
        return valueOf(v);
    }

}
