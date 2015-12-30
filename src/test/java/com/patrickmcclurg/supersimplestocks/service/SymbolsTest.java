package com.patrickmcclurg.supersimplestocks.service;

import com.patrickmcclurg.supersimplestocks.model.Symbol;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;


public class SymbolsTest {

    private Symbols symbols;

    @Before
    public void setup() {
        initSymbols();
    }

    private void initSymbols() {
        symbols = new Symbols();
        symbols.addSymbol(new Symbol("JPM", 10000));
        symbols.addSymbol(new Symbol("CITI", 15000));
        symbols.addSymbol(new Symbol("BARC", 15000));
    }

    @Test
    public void shouldAddValidSymbol() throws Exception {
        int countBefore = symbols.getSymbols().size();

        symbols.addSymbol(new Symbol("IBM", 2000));
        int countAfter = symbols.getSymbols().size();

        assertThat(countAfter, is(countBefore + 1));
    }

    @Test
    public void shouldNotAddInvalidSymbol() throws Exception {
        int countBefore = symbols.getSymbols().size();

        symbols.addSymbol(new Symbol(null, 2000));
        symbols.addSymbol(new Symbol("", 2000));
        symbols.addSymbol(new Symbol("APPL", 0));
        symbols.addSymbol(null);

        int countAfter = symbols.getSymbols().size();

        assertThat(countAfter, is(countBefore));
    }

    @Test
    public void shouldReturnSymbolWithValidIdentifier() throws Exception {
        assertThat(symbols.getSymbolFor("JPM"), is(notNullValue()));
    }

    @Test
    public void shouldReturnNullOnInvalidIdentifier() throws Exception {
        assertThat(symbols.getSymbolFor("invalid identifier"), is(nullValue()));
    }
}
