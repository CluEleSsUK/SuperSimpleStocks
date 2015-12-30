package com.patrickmcclurg.supersimplestocks.service;

import com.patrickmcclurg.supersimplestocks.model.Symbol;
import com.patrickmcclurg.supersimplestocks.model.Trade;
import com.patrickmcclurg.supersimplestocks.utils.ExchangeUtils;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static com.patrickmcclurg.supersimplestocks.model.Trade.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DefaultExchangeTest {

    private Exchange exchange;
    private Symbol validSymbol;
    private static final String SYMBOL_ID = "JPM";


    @Before
    public void setup() {
        exchange = new DefaultExchange(ExchangeUtils.defaultSymbols());
        validSymbol = exchange.getSymbols().getSymbolFor(SYMBOL_ID);
    }

    @Test
    public void shouldIncreaseListOfTradesAfterTrade() {
        int before = getTradesFor(SYMBOL_ID).size();

        exchange.makeTrade(validSymbol, 1000, Side.BUY);

        int after = getTradesFor(SYMBOL_ID).size();
        assertThat(after, is(before + 1));
    }

    @Test
    public void shouldReturnPriceOfLatestTradeForSymbol() {
        BigDecimal price = new BigDecimal(50);

        exchange.makeTrade(validSymbol, 1000, Side.BUY, price);

        assertThat(exchange.pricePerUnit(validSymbol, Side.BUY), is(price));
    }

    private List<Trade> getTradesFor(String id) {
        return exchange.getSymbols().getSymbolFor(id).getTrades();
    }
}
