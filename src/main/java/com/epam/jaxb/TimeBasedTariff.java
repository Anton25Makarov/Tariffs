
package com.epam.jaxb;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TimeBasedTariff complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TimeBasedTariff">
 *   &lt;complexContent>
 *     &lt;extension base="{com.epam.entities}Tariff">
 *       &lt;sequence>
 *         &lt;element name="smsPrice" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="callPrices" type="{com.epam.entities}CallPrices"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TimeBasedTariff", namespace = "com.epam.entities", propOrder = {
    "smsPrice",
    "callPrices"
})
public class TimeBasedTariff
    extends Tariff
{

    @XmlElement(namespace = "com.epam.entities", required = true)
    protected BigDecimal smsPrice;
    @XmlElement(namespace = "com.epam.entities", required = true)
    protected CallPrices callPrices;

    /**
     * Gets the value of the smsPrice property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSmsPrice() {
        return smsPrice;
    }

    /**
     * Sets the value of the smsPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSmsPrice(BigDecimal value) {
        this.smsPrice = value;
    }

    /**
     * Gets the value of the callPrices property.
     * 
     * @return
     *     possible object is
     *     {@link CallPrices }
     *     
     */
    public CallPrices getCallPrices() {
        return callPrices;
    }

    /**
     * Sets the value of the callPrices property.
     * 
     * @param value
     *     allowed object is
     *     {@link CallPrices }
     *     
     */
    public void setCallPrices(CallPrices value) {
        this.callPrices = value;
    }

}
