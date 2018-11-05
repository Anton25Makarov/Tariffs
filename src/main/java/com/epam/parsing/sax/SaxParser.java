package com.epam.parsing.sax;

import com.epam.entities.Tariff;
import com.epam.exception.ParseException;
import com.epam.parsing.Parser;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.List;

public class SaxParser implements Parser {

    @Override
    public List<Tariff> parse(String filePath) throws ParseException {

        TariffHandlerSax handler = new TariffHandlerSax();

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(filePath);
        } catch (SAXException e) {
            throw new ParseException("SAXException", e);
        } catch (IOException e) {
            throw new ParseException("I/O Exception", e);
        }

        return handler.getTariffs();
    }
}
