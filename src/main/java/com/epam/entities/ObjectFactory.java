package com.epam.entities;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private final static QName _Tariff_QNAME =
            new QName("http://epam.com/tariff", "tariff");
    private final static QName _TimeBasedTariff_QNAME =
            new QName("http://epam.com/tariff", "time-based-tariff");
    private final static QName _UnlimitedTariff_QNAME =
            new QName("http://epam.com/tariff", "unlimited-tariff");


    public ObjectFactory() {
    }

    public UnlimitedTariff createUnlimitedTariff() {
        return new UnlimitedTariff();
    }

    public TimeBasedTariff createTimeBasedTariff() {
        return new TimeBasedTariff();
    }

    public Tariffs createTariffs() {
        return new Tariffs();
    }

    public CallPrices createCallPrices() {
        return new CallPrices();
    }

    @XmlElementDecl(namespace = "http://epam.com/tariff", name = "tariff")
    public JAXBElement<Tariff> createTariff(Tariff value) {
        return new JAXBElement<>(_Tariff_QNAME, Tariff.class, null, value);
    }

    @XmlElementDecl(namespace = "http://epam.com/tariff",
            name = "time-based-tariff",
            substitutionHeadNamespace = "http://epam.com/tariff",
            substitutionHeadName = "tariff")
    public JAXBElement<TimeBasedTariff> createTimeBasedTariff(TimeBasedTariff value) {
        return new JAXBElement<>(_TimeBasedTariff_QNAME, TimeBasedTariff.class, null, value);
    }

    @XmlElementDecl(namespace = "http://epam.com/tariff",
            name = "unlimited-tariff",
            substitutionHeadNamespace = "http://epam.com/tariff",
            substitutionHeadName = "tariff")
    public JAXBElement<UnlimitedTariff> createUnlimitedTariff(UnlimitedTariff value) {
        return new JAXBElement<>(_UnlimitedTariff_QNAME, UnlimitedTariff.class, null, value);
    }
}
