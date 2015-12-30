package com.patrickmcclurg.supersimplestocks.service;

import com.patrickmcclurg.supersimplestocks.model.Symbol;
import com.patrickmcclurg.supersimplestocks.model.Trade;
import com.patrickmcclurg.supersimplestocks.utils.AccountingUtility;
import com.patrickmcclurg.supersimplestocks.utils.ExchangeUtils;

import java.math.BigDecimal;

public class DefaultExchange implements Exchange {

    private Symbols symbols;
    private AccountingUtility accountingUtility;

    public DefaultExchange(Symbols symbols, AccountingUtility accountingUtility) {
        this.symbols = symbols;
        this.accountingUtility = accountingUtility;
    }

    @Override
    public void makeTrade(Symbol symbol, int volume, Trade.Side buyOrSell) {
        symbol.getTrades().add(new Trade(currentTimestamp(), volume, buyOrSell, pricePerUnit(symbol, buyOrSell)));
    }

    @Override
    public void makeTrade(Symbol symbol, int volume, Trade.Side buyOrSell, BigDecimal price) {
        symbol.getTrades().add(new Trade(currentTimestamp(), volume, buyOrSell, price));
    }

    @Override
    public BigDecimal pricePerUnit(Symbol symbol, Trade.Side buyOrSell) {
        return ExchangeUtils.calculateStockPrice(symbol);
    }

    @Override
    public BigDecimal getGBCEAllShareIndex() {
        return accountingUtility.calculateGeometricMean();
    }

    @Override
    public Symbols getSymbols() {
        return symbols;
    }

    private Long currentTimestamp() {
        return System.currentTimeMillis();
    }
}
