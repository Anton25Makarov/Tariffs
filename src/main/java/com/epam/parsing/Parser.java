package com.epam.parsing;

import com.epam.entities.Tariff;
import com.epam.exception.ParseException;

import javax.xml.bind.JAXBException;
import java.util.List;

public interface Parser {
    List<Tariff> parse(String filePath) throws JAXBException, ParseException; // свой экзепшн
}
