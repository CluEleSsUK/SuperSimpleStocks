package com.patrickmcclurg.supersimplestocks.service;

import com.patrickmcclurg.supersimplestocks.model.Symbol;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public class Symbols {

    private Set<Symbol> symbols;

    public Symbols() {
        symbols = new HashSet<>();
    }

    public Symbol getSymbolFor(String identifier) {
        try {
            return symbols.stream().filter(
                    p -> p.getIdentifier().equals(identifier))
                    .findFirst().get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public void addSymbol(Symbol symbol) {
        if (isValid(symbol))
            symbols.add(symbol);
    }

    private boolean isValid(Symbol symbol) {
        return symbol != null &&
               symbol.getIdentifier() != null &&
               !symbol.getIdentifier().equals("") &&
               !identifierExists(symbol.getIdentifier()) &&
               symbol.getTotalNumberOfShares() > 0;
    }

    private boolean identifierExists(String identifier) {
        return symbols.stream().anyMatch(p -> p.getIdentifier().equals(identifier));
    }

    public Set<Symbol> getSymbols() {
        return symbols;
    }
}
