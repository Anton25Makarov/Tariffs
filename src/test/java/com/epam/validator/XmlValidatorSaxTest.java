package com.epam.validator;

import org.junit.Assert;
import org.junit.Test;


public class XmlValidatorSaxTest {

    @Test
    public void valid(){
        XmlValidatorSax validatorSax = new XmlValidatorSax();

        boolean result = validatorSax.isValid("src/test/resources/input.xml");

        Assert.assertTrue(result);
    }
}