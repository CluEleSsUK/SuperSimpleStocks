Super simple stocks
===================

This is a repo for the super simple stocks app, providing an interface for some basic trade functions, as well as a utility for general exchange mathematics.  

Exchange interface
------------------
The *Exchange* interface contains the main bulk of functionality within the package.  Its default implementation can be found in *DefaultExchange* and provides methods to do the following:
* to make trades (with or without specifying a price) 
* getting the price per unit for a given stock symbol
* calculating the GBCE all share index tracker
* getting a list of the symbols listed on the exchange

Accounting utilities
--------------------
A set of utilities for finding out the dividend yield and P/E ratio can be found in the *AccountingUtilities* class.  This is also instantiated in the *DefaultExchange* for use in calculating the GBCE all share index.
The operation of these is demonstrated in the unit testing.  

Still to do
-----------
* complete unit testing
* add static test data
