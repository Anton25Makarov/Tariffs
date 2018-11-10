package com.epam.parsing.dom;

import com.epam.entities.*;
import com.epam.exception.ParseException;
import com.epam.parsing.Parser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DomParser implements Parser {
    private static final int SCALE = 2;
    private static final int ROUND = BigDecimal.ROUND_HALF_DOWN;

    @Override
    public List<Tariff> parse(String filePath) throws ParseException {
        List<Tariff> tariffs = new ArrayList<>();
        DocumentBuilder documentBuilder;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new ParseException(e);
        }

        buildListTariffs(filePath, documentBuilder, tariffs);

        return tariffs;
    }

    private void buildListTariffs(String fileName, DocumentBuilder documentBuilder, List<Tariff> tariffs)
            throws ParseException {
        Document doc;

        try {
            doc = documentBuilder.parse(fileName);
        } catch (SAXException | IOException e) {
            throw new ParseException(e);
        }

        Element root = doc.getDocumentElement();
        NodeList TimeBasedTariffsList = root.getElementsByTagName("time-based-tariff");
        NodeList UnlimitedTariffsList = root.getElementsByTagName("unlimited-tariff");

        for (int i = 0; i < TimeBasedTariffsList.getLength(); i++) {
            Element tariffElement = (Element) TimeBasedTariffsList.item(i);
            Tariff tariff = buildTariff(tariffElement);
            if (tariff != null) {
                tariffs.add(tariff);
            }
        }

        for (int i = 0; i < UnlimitedTariffsList.getLength(); i++) {
            Element tariffElement = (Element) UnlimitedTariffsList.item(i);
            Tariff tariff = buildTariff(tariffElement);
            if (tariff != null) {
                tariffs.add(tariff);
            }
        }
    }

    private Tariff buildTariff(Element tariffElement) {
        Tariff tariff;

        String name = tariffElement.getAttribute("name");

        String stringOperatorName = tariffElement.getAttribute("operator-name");
        OperatorName operatorName = OperatorName.VELCOM; // by default
        if (!stringOperatorName.isEmpty()) {
            operatorName = OperatorName.valueOf(stringOperatorName);
        }

        switch (tariffElement.getTagName()) {
            case "time-based-tariff":
                String smsPrice = getElementTextContent(tariffElement, "sms-price");
                Element callPricesElement =
                        (Element) tariffElement.getElementsByTagName("call-prices").item(0);
                String priceInsideNetworkString =
                        getElementTextContent(callPricesElement, "price-inside-network");
                String priceOutsideNetworkString =
                        getElementTextContent(callPricesElement, "price-outside-network");
                String priceLandlinesNetworkString =
                        getElementTextContent(callPricesElement, "price-landlines-network");

                BigDecimal smsDecimal = new BigDecimal(smsPrice).setScale(SCALE, ROUND);
                CallPrices callPrices = new CallPrices();
                BigDecimal priceInsideDecimal =
                        new BigDecimal(priceInsideNetworkString).setScale(SCALE, ROUND);
                BigDecimal priceOutsideDecimal =
                        new BigDecimal(priceOutsideNetworkString).setScale(SCALE, ROUND);
                BigDecimal priceLandlinesDecimal =
                        new BigDecimal(priceLandlinesNetworkString).setScale(SCALE, ROUND);

                callPrices.setPriceInsideNetwork(priceInsideDecimal);
                callPrices.setPriceOutsideNetwork(priceOutsideDecimal);
                callPrices.setPriceLandLinesNetwork(priceLandlinesDecimal);


                tariff = new TimeBasedTariff();

                tariff.setName(name);
                tariff.setOperatorName(operatorName);
                ((TimeBasedTariff) tariff).setSmsPrice(smsDecimal);
                ((TimeBasedTariff) tariff).setCallPrices(callPrices);
                break;
            case "unlimited-tariff":

                String payrollString = getElementTextContent(tariffElement, "payroll");
                BigDecimal payrollDecimal = new BigDecimal(payrollString).setScale(SCALE, ROUND);

                tariff = new UnlimitedTariff();

                tariff.setName(name);
                tariff.setOperatorName(operatorName);
                ((UnlimitedTariff) tariff).setPayroll(payrollDecimal);
                break;
            default:
                throw new IllegalArgumentException();
        }

        return tariff;
    }

    private String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        return node.getTextContent();
    }
}
