package com.epam.validator;

import java.io.File;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

public class XmlValidatorSax {
    private static final String XSD_PATH = "src/main/resources/Tariffs.xsd";
    private static final String LANGUAGE = XMLConstants.W3C_XML_SCHEMA_NS_URI;
    private static final Logger LOGGER = Logger.getLogger(XmlValidatorSax.class);

    public boolean isValid(String xmlFilePath) {
        SchemaFactory factory = SchemaFactory.newInstance(LANGUAGE);
        File xsdPath = new File(XSD_PATH);

        try {
            // creating schema
            Schema schema = factory.newSchema(xsdPath);
            // creating validator
            Validator validator = schema.newValidator();
            // check document
            Source source = new StreamSource(xmlFilePath);
            validator.validate(source);
            System.out.println(xmlFilePath + " is valid");

            return true;
        } catch (SAXException e) {
            LOGGER.error(xmlFilePath + "is not valid: " + e.getMessage());
            //System.err.print("validation " + xmlFilePath + " is not valid because " + e.getMessage());
        } catch (IOException e) {
            LOGGER.error("I/O Exception: " + e.getStackTrace());
            //System.err.print(xmlFilePath + " is not valid because " + e.getMessage());
        }
        return false;
    }
}
