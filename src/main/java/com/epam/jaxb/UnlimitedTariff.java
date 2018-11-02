
package com.epam.jaxb;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UnlimitedTariff complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UnlimitedTariff">
 *   &lt;complexContent>
 *     &lt;extension base="{com.epam.entities}Tariff">
 *       &lt;sequence>
 *         &lt;element name="payroll" type="{com.epam.entities}decimal"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UnlimitedTariff", namespace = "com.epam.entities", propOrder = {
    "payroll"
})
public class UnlimitedTariff
    extends Tariff
{

    @XmlElement(namespace = "com.epam.entities", required = true)
    protected BigDecimal payroll;

    /**
     * Gets the value of the payroll property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPayroll() {
        return payroll;
    }

    /**
     * Sets the value of the payroll property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPayroll(BigDecimal value) {
        this.payroll = value;
    }

}
