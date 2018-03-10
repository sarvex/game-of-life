package com.sarvex.gameoflife.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * GridReader.java
 * Class for converting inputted string of state symbols into array of cell objects
 */
public class GridReader {

  private static final String NEW_LINE = System.getProperty("line.separator");

  // Returns array of cell objects created from inputted string
  public Cell[][] loadFrom(final String gridContents) {
    List<Cell[]> rows = new ArrayList<>();

    String[] rowValues = splitIntoRows(gridContents); // First separate total content into different rows
    for (String row : rowValues) {
      Cell[] cellsInRow = splitIntoCells(row); // Then separate each row into different cells
      rows.add(cellsInRow); // Save the cells of a row into a list
    }

    // Convert list into 2D array of new cell objects
    return rows.toArray(new Cell[0][0]);
  }

  // Helper function, converts series of symbols into array of Cell objects
  private Cell[] splitIntoCells(final String row) {
    char[] cellSymbols = row.trim().toCharArray(); // First convert string into array of state symbols
    List<Cell> cellsInRow = new ArrayList<>();
    for (char cellSymbol : cellSymbols) { // Then for each symbol
      Cell cell = Cell.fromSymbol(Character.toString(cellSymbol)); // Create a new cell object
      if (cell == null) {
        throw new IllegalArgumentException();
      }
      cellsInRow.add(cell); // And save it to return
    }
    return cellsInRow.toArray(new Cell[0]);
  }

  // Helper function, converts input grid into array of string symbols
  private String[] splitIntoRows(final String gridContents) {
    return gridContents.split(NEW_LINE);
  }

}
