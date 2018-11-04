package com.epam.entities;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tariff")
@XmlSeeAlso({
        UnlimitedTariff.class,
        TimeBasedTariff.class
})
public abstract class Tariff {
    @XmlAttribute(name = "name", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    private String name;
    @XmlAttribute(name = "operator-name")
    private OperatorName operatorName = OperatorName.VELCOM;

    public Tariff(String name, OperatorName operatorName) {
        this.name = name;
        this.operatorName = operatorName;
    }

    public Tariff() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OperatorName getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(OperatorName operatorName) {
        this.operatorName = operatorName;
    }

    @Override
    public String toString() {
        return "Tariff{" +
                "name='" + name + '\'' +
                ", operatorName=" + operatorName +
                '}';
    }
}
