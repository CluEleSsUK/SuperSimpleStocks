package com.patrickmcclurg.supersimplestocks.utils;

import com.patrickmcclurg.supersimplestocks.model.Symbol;
import com.patrickmcclurg.supersimplestocks.service.Symbols;
import com.patrickmcclurg.supersimplestocks.model.Trade;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by offthegrid on 28/12/2015.
 */
public class ExchangeUtils {

    private static final long FIFTEEN_MINUTES = 900000;

    public static Symbols defaultSymbols() {
        Symbols s = new Symbols();
        s.addSymbol(new Symbol("APPL", 10000));
        s.addSymbol(new Symbol("JPM", 20000));
        return s;
    }

    public static BigDecimal calculateStockPrice(Symbol symbol) {
        List<Trade> trades = tradesInLastFifteenMins(symbol);
        double total = 0;

        for (Trade trade : trades) {
            total += trade.getPrice().doubleValue() * trade.getNumberOfShares();
        }

        return new BigDecimal(total / (double)symbol.getTotalNumberOfShares());
    }

    private static List<Trade> tradesInLastFifteenMins(Symbol symbol) {
        return symbol.getTrades().stream().filter(p -> p.getTimestamp() > fifteenMinsAgo()).collect(Collectors.toList());
    }

    private static long fifteenMinsAgo() {
        return System.currentTimeMillis() - FIFTEEN_MINUTES;
    }

}
