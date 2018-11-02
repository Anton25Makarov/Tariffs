
package com.epam.jaxb;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.epam package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _UnlimitedTariff_QNAME = new QName("com.epam.entities", "unlimitedTariff");
    private final static QName _TimeBasedTariff_QNAME = new QName("com.epam.entities", "timeBasedTariff");
    private final static QName _Tariff_QNAME = new QName("com.epam.entities", "tariff");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.epam
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UnlimitedTariff }
     * 
     */
    public UnlimitedTariff createUnlimitedTariff() {
        return new UnlimitedTariff();
    }

    /**
     * Create an instance of {@link Tariff }
     * 
     */
    public Tariff createTariff() {
        return new Tariff();
    }

    /**
     * Create an instance of {@link TimeBasedTariff }
     * 
     */
    public TimeBasedTariff createTimeBasedTariff() {
        return new TimeBasedTariff();
    }

    /**
     * Create an instance of {@link Tariffs }
     * 
     */
    public Tariffs createTariffs() {
        return new Tariffs();
    }

    /**
     * Create an instance of {@link CallPrices }
     * 
     */
    public CallPrices createCallPrices() {
        return new CallPrices();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnlimitedTariff }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.epam.entities", name = "unlimitedTariff", substitutionHeadNamespace = "com.epam.entities", substitutionHeadName = "tariff")
    public JAXBElement<UnlimitedTariff> createUnlimitedTariff(UnlimitedTariff value) {
        return new JAXBElement<UnlimitedTariff>(_UnlimitedTariff_QNAME, UnlimitedTariff.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimeBasedTariff }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.epam.entities", name = "timeBasedTariff", substitutionHeadNamespace = "com.epam.entities", substitutionHeadName = "tariff")
    public JAXBElement<TimeBasedTariff> createTimeBasedTariff(TimeBasedTariff value) {
        return new JAXBElement<TimeBasedTariff>(_TimeBasedTariff_QNAME, TimeBasedTariff.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Tariff }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com.epam.entities", name = "tariff")
    public JAXBElement<Tariff> createTariff(Tariff value) {
        return new JAXBElement<Tariff>(_Tariff_QNAME, Tariff.class, null, value);
    }

}
