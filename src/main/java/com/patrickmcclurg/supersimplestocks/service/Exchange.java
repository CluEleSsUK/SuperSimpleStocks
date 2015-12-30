package com.patrickmcclurg.supersimplestocks.service;

import com.patrickmcclurg.supersimplestocks.model.Symbol;
import com.patrickmcclurg.supersimplestocks.model.Trade;

import java.math.BigDecimal;

public interface Exchange {
    void makeTrade(Symbol symbol, int volume, Trade.Side buyOrSell);
    void makeTrade(Symbol symbol, int volume, Trade.Side buyOrSell, BigDecimal price);
    BigDecimal pricePerUnit(Symbol symbol, Trade.Side buyOrSell);
    BigDecimal getGBCEAllShareIndex();
    Symbols getSymbols();

}
