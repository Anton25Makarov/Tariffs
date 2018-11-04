package com.epam.parsing.sax;

import com.epam.entities.*;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.math.BigDecimal;
import java.util.*;

public class TariffHandlerSax extends DefaultHandler {

    private List<Tariff> tariffs;
    private Tariff currentTariff;
    private TariffEnum currentEnum;
    private EnumSet<TariffEnum> withText;

    public TariffHandlerSax() {
        this.tariffs = new ArrayList<>();
        withText = EnumSet.range(TariffEnum.SMS_PRICE, TariffEnum.PAYROLL);
    }

    public List<Tariff> getTariffs() {
        return tariffs;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        OperatorName tempOperatorName;
        switch (localName) {
            case "unlimited-tariff":
                currentTariff = new UnlimitedTariff();
                currentTariff.setName(attrs.getValue("name"));

                tempOperatorName = OperatorName.VELCOM; // by default
                if (attrs.getLength() == 2) {
                    String attrValue = attrs.getValue("operator-name");
                    tempOperatorName = OperatorName.valueOf(attrValue);
                }
                currentTariff.setOperatorName(tempOperatorName);
                break;
            case "time-based-tariff":
                currentTariff = new TimeBasedTariff();
                currentTariff.setName(attrs.getValue("name"));

                tempOperatorName = OperatorName.VELCOM; // by default
                if (attrs.getLength() == 2) {
                    String attrValue = attrs.getValue("operator-name");
                    tempOperatorName = OperatorName.valueOf(attrValue);
                }
                currentTariff.setOperatorName(tempOperatorName);
                break;
            case "call-prices":
                ((TimeBasedTariff) currentTariff).setCallPrices(new CallPrices());
                break;
            case "tariffs":
                break;
            default:
                String stringEnum = localName.toUpperCase();
                stringEnum = stringEnum.replace('-', '_');
                TariffEnum tempTariffEnum = TariffEnum.valueOf(stringEnum);
                if (withText.contains(tempTariffEnum)) {
                    currentEnum = tempTariffEnum;
                }
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if ("time-based-tariff".equals(localName) || "unlimited-tariff".equals(localName)) {
            tariffs.add(currentTariff);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String s = new String(ch, start, length).trim();
        BigDecimal decimal;
        CallPrices callPrices;
        if (currentEnum != null) {
            switch (currentEnum) {
                case SMS_PRICE:

                    decimal = new BigDecimal(s).setScale(2, BigDecimal.ROUND_HALF_DOWN);
                    ((TimeBasedTariff) currentTariff).setSmsPrice(decimal);
                    break;
                case PRICE_INSIDE_NETWORK:
                    decimal = new BigDecimal(s).setScale(2, BigDecimal.ROUND_HALF_DOWN);
                    callPrices = ((TimeBasedTariff) currentTariff).getCallPrices();
                    callPrices.setPriceInsideNetwork(decimal);
                    break;
                case PRICE_OUTSIDE_NETWORK:
                    decimal = new BigDecimal(s).setScale(2, BigDecimal.ROUND_HALF_DOWN);
                    callPrices = ((TimeBasedTariff) currentTariff).getCallPrices();
                    callPrices.setPriceOutsideNetwork(decimal);
                    break;
                case PRICE_LANDLINES_NETWORK:
                    decimal = new BigDecimal(s).setScale(2, BigDecimal.ROUND_HALF_DOWN);
                    callPrices = ((TimeBasedTariff) currentTariff).getCallPrices();
                    callPrices.setPriceLandLinesNetwork(decimal);
                    break;
                case PAYROLL:
                    decimal = new BigDecimal(s).setScale(2, BigDecimal.ROUND_HALF_DOWN);
                    ((UnlimitedTariff) currentTariff).setPayroll(decimal);
                    break;
                default:
                    throw new EnumConstantNotPresentException(
                            currentEnum.getDeclaringClass(), currentEnum.name());
            }
        }
        currentEnum = null;
    }
}

