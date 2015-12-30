package com.patrickmcclurg.supersimplestocks.model;

import java.math.BigDecimal;

public class Trade {

    private long timestamp;
    private int numberOfShares;
    private Side side;
    private BigDecimal price;

    public Trade(long timestamp, int numberOfShares, Side side, BigDecimal price) {
        this.timestamp = timestamp;
        this.numberOfShares = numberOfShares;
        this.side = side;
        this.price = price;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getNumberOfShares() {
        return numberOfShares;
    }

    public void setNumberOfShares(int numberOfShares) {
        this.numberOfShares = numberOfShares;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public enum Side {
        BUY,
        SELL
    }
}
