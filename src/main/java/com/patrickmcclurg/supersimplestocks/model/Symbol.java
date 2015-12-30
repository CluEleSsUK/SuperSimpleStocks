package com.patrickmcclurg.supersimplestocks.model;

import java.util.ArrayList;
import java.util.List;

public class Symbol {
    private String identifier;
    private int totalNumberOfShares;
    private List<Trade> trades;

    public Symbol(String identifier, int totalNumberOfShares) {
        this.identifier = identifier;
        this.totalNumberOfShares = totalNumberOfShares;
        this.trades = new ArrayList<>();
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public int getTotalNumberOfShares() {
        return totalNumberOfShares;
    }

    public void setTotalNumberOfShares(int totalNumberOfShares) {
        this.totalNumberOfShares = totalNumberOfShares;
    }

    public List<Trade> getTrades() {
        if (trades == null) {
            return new ArrayList<>();
        }
        return trades;
    }

    public void setTrades(List<Trade> trades) {
        this.trades = trades;
    }
}
