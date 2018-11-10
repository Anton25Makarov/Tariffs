package com.epam.parsing.sax;

import com.epam.entities.*;
import com.epam.exception.ParseException;
import com.epam.parsing.Parser;
import com.epam.parsing.sax.SaxParser;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.math.BigDecimal;
import java.util.List;

public class SaxParserTest {
    private static final String INPUT_FILE = "src/test/resources/input.xml";
    private static final BigDecimal SMS_PRICE = new BigDecimal(1).
            setScale(2, BigDecimal.ROUND_HALF_DOWN);
    private static final BigDecimal PRICE_INSIDE_NETWORK = new BigDecimal(2.2).
            setScale(2, BigDecimal.ROUND_HALF_DOWN);
    private static final BigDecimal PRICE_OUTSIDE_NETWORK = new BigDecimal(3.3).
            setScale(2, BigDecimal.ROUND_HALF_DOWN);
    private static final BigDecimal PRICE_LANDLINES_NETWORK = new BigDecimal(4.4).
            setScale(2, BigDecimal.ROUND_HALF_DOWN);
    private static final BigDecimal PAYROLL = new BigDecimal(15.50).
            setScale(2, BigDecimal.ROUND_HALF_DOWN);

    @Test
    public void shouldParseWhenXmlIsValid() throws JAXBException, ParseException {
        // given
        Parser parser = new SaxParser();
        // when
        List<Tariff> actual = parser.parse(INPUT_FILE);
        // then
        Assert.assertEquals(4, actual.size());

        TimeBasedTariff first = (TimeBasedTariff) actual.get(0);

        Assert.assertEquals(first.getClass(), TimeBasedTariff.class);

        CallPrices callPrices = first.getCallPrices();
        OperatorName firstOperatorName = first.getOperatorName();

        Assert.assertEquals("Lemon", first.getName());
        Assert.assertEquals("Velcom".toUpperCase(), firstOperatorName.value());
        Assert.assertEquals(SMS_PRICE, first.getSmsPrice());
        Assert.assertEquals(PRICE_INSIDE_NETWORK, callPrices.getPriceInsideNetwork());
        Assert.assertEquals(PRICE_OUTSIDE_NETWORK, callPrices.getPriceOutsideNetwork());
        Assert.assertEquals(PRICE_LANDLINES_NETWORK, callPrices.getPriceLandLinesNetwork());

        UnlimitedTariff second = (UnlimitedTariff) actual.get(1);
        OperatorName secondOperatorName = second.getOperatorName();

        Assert.assertEquals(second.getClass(), UnlimitedTariff.class);

        Assert.assertEquals("Comfort", second.getName());
        Assert.assertEquals("MTS", secondOperatorName.value());
        Assert.assertEquals(PAYROLL, second.getPayroll());
    }
}