package com.epam.parsing;

import com.epam.entities.*;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class TariffHandler extends DefaultHandler {

    private Set<Tariff> tariffs;
    private Tariff currentTariff;
    private TariffEnum currentEnum;
    private EnumSet<TariffEnum> withText;

    public TariffHandler(Set<Tariff> tariffs) {
        this.tariffs = new HashSet<>();
        withText = EnumSet.range(TariffEnum.CALL_PRICES, TariffEnum.SMS_PRICE);
    }

    public Set<Tariff> getTariffs() {
        return tariffs;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if ("unlimitedTariff".equals(localName)) {
            currentTariff = new UnlimitedTariff();
            currentTariff.setName(attrs.getValue("name"));
            OperatorName temp = OperatorName.valueOf(attrs.getValue("operatorName"));
            currentTariff.setOperatorName(temp);
            /*if (attrs.getLength() == 2) {
                current.setFaculty(attrs.getValue(1));
            }*/
        } else if ("TimeBasedTariff".equals(localName)) {
            currentTariff = new TimeBasedTariff();
            currentTariff.setName(attrs.getValue("name"));
            OperatorName temp = OperatorName.valueOf(attrs.getValue("operatorName"));
            currentTariff.setOperatorName(temp);
        } else {
  /*          Tariff temp = StudentEnum.valueOf(localName.toUpperCase());
            if (withText.contains(temp)) {
                currentEnum = temp;*/
        }
    }
}

