package com.epam.parsing;

import com.epam.entities.Tariff;
import com.epam.exception.ParseException;

import java.util.List;

public interface Parser {
    List<Tariff> parse(String filePath) throws ParseException;
}
