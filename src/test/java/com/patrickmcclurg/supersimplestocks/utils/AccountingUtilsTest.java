package com.patrickmcclurg.supersimplestocks.utils;

import com.patrickmcclurg.supersimplestocks.model.Stock;
import com.patrickmcclurg.supersimplestocks.service.Exchange;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static com.patrickmcclurg.supersimplestocks.data.TestData.*;
import static org.mockito.Mockito.when;

public class AccountingUtilsTest {

    //NB the import of TestData.* - any references IN CAPS denote test data from here

    private Exchange exchange;
    private AccountingUtility accounting;

    @Before
    public void setup() {
        exchange = mock(Exchange.class);
        accounting = new AccountingUtility(exchange);

        when(exchange.getSymbols()).thenReturn(VALID_SYMBOLS);
    }

    @Test
    public void shouldReturnCorrectDividendYieldForStock() throws Exception {
        BigDecimal correctValue = null;

        assertThat(accounting.calculateDividendYieldFor(VALID_STOCK), is(correctValue));
    }

    @Test
    public void shouldReturnCorrectPERatioForStock() throws Exception {
        BigDecimal correctValue = null;

        assertThat(accounting.calculatePERatioFor(VALID_STOCK), is(correctValue));
    }

    @Test
    public void shouldReturnCorrectGeometricMean() throws Exception {
        BigDecimal correctValue = null;

        assertThat(accounting.calculatePERatioFor(VALID_STOCK), is(correctValue));
    }
}
