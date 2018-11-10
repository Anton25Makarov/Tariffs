package com.epam.validator;

import org.junit.Assert;
import org.junit.Test;


public class XmlValidatorSaxTest {
    private static final String INPUT_FILE = "src/test/resources/input.xml";

    @Test
    public void shouldReturnTrueIfXmlFileIsValid() {
        XmlValidatorSax validatorSax = new XmlValidatorSax();

        boolean result = validatorSax.isValid(INPUT_FILE);

        Assert.assertTrue(result);
    }
}