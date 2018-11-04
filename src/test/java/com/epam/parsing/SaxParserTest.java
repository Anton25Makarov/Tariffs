package com.epam.parsing;

import com.epam.entities.Tariff;
import com.epam.entities.TimeBasedTariff;
import com.epam.entities.UnlimitedTariff;
import com.epam.exception.ParseException;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.util.List;

public class SaxParserTest {
    private static final String INPUT_FILE = "src/main/test/resources/input.xml";


    @Test
    public void shouldParseWhenXmlIsValid() throws JAXBException, ParseException {
        // given
        Parser parser = new SaxParser();
        // when
        List<Tariff> actual = parser.parse(INPUT_FILE);
        // then
        Assert.assertEquals(3, actual.size());

        TimeBasedTariff first = (TimeBasedTariff) actual.get(0);

        Assert.assertEquals(first.getClass(), Tariff.class);

        Assert.assertEquals("Lemon", first.getName());
        Assert.assertEquals("Velcom", first.getOperatorName());
        Assert.assertEquals(1, first.getSmsPrice());
        Assert.assertEquals(0.5, first.getCallPrices().getPriceInsideNetwork());
        Assert.assertEquals(0.6, first.getCallPrices().getPriceOutsideNetwork());
        Assert.assertEquals(0.7, first.getCallPrices().getPriceLandLinesNetwork());

        UnlimitedTariff second = (UnlimitedTariff) actual.get(1);

        Assert.assertEquals(second.getClass(), Tariff.class);

        Assert.assertEquals("Comfort", second.getName());
        Assert.assertEquals("MTS", second.getOperatorName());
        Assert.assertEquals(7.99, second.getPayroll());
    }
}