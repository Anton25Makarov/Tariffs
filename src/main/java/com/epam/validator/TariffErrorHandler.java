package com.epam.validator;

import java.io.IOException;

import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;


public class TariffErrorHandler extends DefaultHandler {
    // создание регистратора ошибок для пакета by.bsu.valid
    private static final Logger LOGGER = Logger.getLogger(TariffErrorHandler.class);

    public TariffErrorHandler(String log) throws IOException {
        // установка файла и формата вывода ошибок
        LOGGER.addAppender(new FileAppender(new SimpleLayout(), log));
    }

    public void warning(SAXParseException e) {
        LOGGER.warn(getLineAddress(e) + "-" + e.getMessage());
    }

    public void error(SAXParseException e) {
        LOGGER.error(getLineAddress(e) + " - " + e.getMessage());
    }

    public void fatalError(SAXParseException e) {
        LOGGER.fatal(getLineAddress(e) + " - " + e.getMessage());
    }

    private String getLineAddress(SAXParseException e) {
        // определение строки и столбца ошибки
        return e.getLineNumber() + " : " + e.getColumnNumber();
    }
}