package com.epam.entities;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

import com.epam.entities.ObjectFactory;


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
            tariff = new ArrayList<JAXBElement<? extends Tariff>>();
        }
        return this.tariff;
    }

    @Override
    public String toString() {
        return "Tariffs{" +
                "tariff=" + tariff +
                '}';
    }

    //  /*  @XmlElements({
//            @XmlElement(name = "tariff", type = Tariff.class),
//            @XmlElement(name = "time-based-tariff", type = TimeBasedTariff.class),
//            @XmlElement(name = "unlimited-tariff", type = UnlimitedTariff.class),
//    })*/
//
//    //    @XmlElementRef(name = "tariff", namespace = "http://epam.com/tariff", type = Tariff.class)
//    @XmlElementRef(name = "tariff", type = JAXBElement.class)
//    private List<JAXBElement<? extends Tariff>> tariff;
////    private List<Tariff> tariffs;
//
//    public Tariffs() {
//    }
//
////    public List<Tariff> getTariffs() {
////        return this.tariffs;
////    }
//
//    public List<JAXBElement<? extends Tariff>> getTariff() {
//        if (tariff == null) {
//            tariff = new ArrayList<JAXBElement<? extends Tariff>>();
//        }
//        return this.tariff;
//    }
//
//   /* public void setTariffs(List<Tariff> tariffs) {
//        this.tariffs = tariffs;
//    }*/
//
//    @Override
//    public String toString() {
//        return "Tariffs{" +
//                "tariff=" + tariff +
//                '}';
//    }
}
