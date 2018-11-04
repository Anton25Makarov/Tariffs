package com.epam.parsing.jaxb;

import com.epam.entities.Tariff;
import com.epam.entities.Tariffs;
import com.epam.exception.ParseException;
import com.epam.parsing.Parser;

import javax.xml.bind.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JaxbParser implements Parser {

    @Override
    public List<Tariff> parse(String filePath) throws ParseException {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Tariffs.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            File fileXml = new File(filePath);
            Tariffs tariffs = (Tariffs) unmarshaller.unmarshal(fileXml);
            List<Tariff> tariffList = new ArrayList<>();
            List<JAXBElement<? extends Tariff>> jaxbElements = tariffs.getTariff();
            for (JAXBElement<? extends Tariff> jaxbElement : jaxbElements) {
                tariffList.add(jaxbElement.getValue());
            }
            return tariffList;
        } catch (JAXBException e) {
            throw new ParseException("JAXBException", e);
        }
    }

}
