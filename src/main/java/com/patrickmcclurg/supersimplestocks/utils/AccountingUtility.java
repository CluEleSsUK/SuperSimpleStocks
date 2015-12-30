package com.patrickmcclurg.supersimplestocks.utils;

import com.patrickmcclurg.supersimplestocks.model.Stock;
import com.patrickmcclurg.supersimplestocks.model.Symbol;
import com.patrickmcclurg.supersimplestocks.model.Trade.*;
import com.patrickmcclurg.supersimplestocks.service.Exchange;

import java.math.BigDecimal;
import java.util.Set;

public class AccountingUtility {

    private Exchange exchange;

    public AccountingUtility(Exchange exchange) {
        this.exchange = exchange;
    }

    public BigDecimal calculateDividendYieldFor(Stock stock) {
        if (stock.getType() == Stock.Type.COMMON) {
            return commonDividendYield(stock);
        } else {
            return preferredDividendYield(stock);
        }
    }

    private BigDecimal commonDividendYield(Stock stock) {
        return new BigDecimal(
               stock.getLastDividend() /
               priceFor(stock.getSymbolIdentifier()).doubleValue());
    }

    private BigDecimal preferredDividendYield(Stock stock) {
        return new BigDecimal(
               ((double) stock.getParValue()) /
               priceFor(stock.getSymbolIdentifier()).doubleValue());
    }

    public BigDecimal calculatePERatioFor(Stock stock) {
        return new BigDecimal(
            priceFor(stock.getSymbolIdentifier()).doubleValue() /
            stock.getLastDividend()
        );
    }

    public BigDecimal calculateGeometricMean() {
        double total = 0;
        Set<Symbol> symbols = exchange.getSymbols().getSymbols();
        for (Symbol symbol : symbols) {
            total += exchange.pricePerUnit(symbol, Side.BUY).doubleValue();
        }
        return new BigDecimal(total / symbols.size());
    }

    private BigDecimal priceFor(String identifier) {
        return exchange.pricePerUnit(exchange.getSymbols().getSymbolFor(identifier), Side.BUY);
    }
}
