package com.epam.entities;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "tariff"
})
@XmlRootElement(name = "tariffs", namespace = "http://epam.com/tariff")

public class Tariffs {

    @XmlElementRef(name = "tariff", namespace = "http://epam.com/tariff", type = JAXBElement.class)
    protected List<JAXBElement<? extends Tariff>> tariff;

    public List<JAXBElement<? extends Tariff>> getTariff() {
        if (tariff == null) {
            tariff = new ArrayList<>();
        }
        return this.tariff;
    }

    @Override
    public String toString() {
        return "Tariffs{" +
                "tariff=" + tariff +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tariffs tariffs = (Tariffs) o;
        return Objects.equals(tariff, tariffs.tariff);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tariff);
    }
}
