package com.epam.entities;

public abstract class Tariff {
    private String name;
    private OperatorName operatorName;

    public Tariff(String name, OperatorName operatorName) {
        this.name = name;
        this.operatorName = operatorName;
    }

    public String getName() {
        return name;
    }

    public OperatorName getOperatorName() {
        return operatorName;
    }
}
