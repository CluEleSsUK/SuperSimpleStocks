package com.patrickmcclurg.supersimplestocks.model;

public class Stock {

    private Symbol symbol;
    private Type type;
    private int lastDividend;
    private int fixedDividendPercentage;
    private int parValue;

    public Stock(Symbol symbol, Type type) {
        this.symbol = symbol;
        this.type = type;
    }

    public Stock(Symbol symbol, Type type, int lastDividend, int fixedDividendPercentage, int parValue) {
        this.symbol = symbol;
        this.type = type;
        this.lastDividend = lastDividend;
        this.fixedDividendPercentage = fixedDividendPercentage;
        this.parValue = parValue;
    }

    public String getSymbolIdentifier() {
        return symbol.getIdentifier();
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getLastDividend() {
        return lastDividend;
    }

    public void setLastDividend(int lastDividend) {
        this.lastDividend = lastDividend;
    }

    public int getFixedDividendPercentage() {
        return fixedDividendPercentage;
    }

    public void setFixedDividendPercentage(int fixedDividendPercentage) {
        this.fixedDividendPercentage = fixedDividendPercentage;
    }

    public int getParValue() {
        return parValue;
    }

    public void setParValue(int parValue) {
        this.parValue = parValue;
    }

    public enum Type {
        PREFERRED,
        COMMON
    }
}
