
package com.epam.jaxb;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CallPrices complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CallPrices">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="priceInsideNetwork" type="{com.epam.entities}decimal"/>
 *         &lt;element name="priceOutsideNetwork" type="{com.epam.entities}decimal"/>
 *         &lt;element name="priceLandLineNetwork" type="{com.epam.entities}decimal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CallPrices", namespace = "com.epam.entities", propOrder = {
    "priceInsideNetwork",
    "priceOutsideNetwork",
    "priceLandLineNetwork"
})
public class CallPrices {

    @XmlElement(namespace = "com.epam.entities", required = true)
    protected BigDecimal priceInsideNetwork;
    @XmlElement(namespace = "com.epam.entities", required = true)
    protected BigDecimal priceOutsideNetwork;
    @XmlElement(namespace = "com.epam.entities", required = true)
    protected BigDecimal priceLandLineNetwork;

    /**
     * Gets the value of the priceInsideNetwork property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPriceInsideNetwork() {
        return priceInsideNetwork;
    }

    /**
     * Sets the value of the priceInsideNetwork property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPriceInsideNetwork(BigDecimal value) {
        this.priceInsideNetwork = value;
    }

    /**
     * Gets the value of the priceOutsideNetwork property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPriceOutsideNetwork() {
        return priceOutsideNetwork;
    }

    /**
     * Sets the value of the priceOutsideNetwork property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPriceOutsideNetwork(BigDecimal value) {
        this.priceOutsideNetwork = value;
    }

    /**
     * Gets the value of the priceLandLineNetwork property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPriceLandLineNetwork() {
        return priceLandLineNetwork;
    }

    /**
     * Sets the value of the priceLandLineNetwork property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPriceLandLineNetwork(BigDecimal value) {
        this.priceLandLineNetwork = value;
    }

}
