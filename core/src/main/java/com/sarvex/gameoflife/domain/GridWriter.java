package com.sarvex.gameoflife.domain;

/**
 * GridWriter.java
 * Class for easy printing/showing of the grid contents
 */
public class GridWriter {

  private static final String LINE_SEPARATOR = System.getProperty("line.separator");

  // Functions returns the status of the cells in the grid as a string, for printing
  public String convertToString(final Cell[][] gridContents) {
    StringBuilder printedGrid = new StringBuilder();
    for (Cell[] row : gridContents) {
      for (Cell cell : row) {
        printedGrid.append(cell.toString()); // Save the cell's status for printing
      }

      // Add separator to denote the next row
      // Note: does not add separator for empty rows
      if (row.length > 0) {
        printedGrid.append(LINE_SEPARATOR);
      }
    }
    return printedGrid.toString();
  }
}
