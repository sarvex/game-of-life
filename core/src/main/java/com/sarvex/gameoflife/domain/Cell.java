package com.sarvex.gameoflife.domain;

/**
 * Cell.java
 * Cell object class, contains information on individual cells (positions) in the grid
 */
public enum Cell {
  // Symbols to represent cell status
  LIVE_CELL("*"), DEAD_CELL(".");

  private final String symbol;

  Cell(final String initialSymbol) {
    this.symbol = initialSymbol;
  }

  // Function used for creating a cell given a string
  static Cell fromSymbol(final String symbol) {
    Cell cellRepresentedBySymbol = null;
    for (Cell cell : Cell.values()) {
      if (cell.symbol.equals(symbol)) {
        cellRepresentedBySymbol = cell;
        break;
      }
    }
    return cellRepresentedBySymbol;
  }

  // Override function for easy printing of cell's symbol
  // Functions identically to default getter ( getSymbol() )
  @Override
  public String toString() {
    return symbol;
  }

  // Default getter
  public String getSymbol() {
    return symbol;
  }
}
