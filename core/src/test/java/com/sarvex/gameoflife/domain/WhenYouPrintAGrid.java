package com.sarvex.gameoflife.domain;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class WhenYouPrintAGrid {

  private final String NEW_LINE = System.getProperty("line.separator");

  @Test
  public void shouldBeAbleToReadAGridOfCellsFromAString() {
    Cell[][] gridContents = {
        {Cell.DEAD_CELL, Cell.DEAD_CELL, Cell.DEAD_CELL},
        {Cell.DEAD_CELL, Cell.DEAD_CELL, Cell.DEAD_CELL},
        {Cell.DEAD_CELL, Cell.DEAD_CELL, Cell.DEAD_CELL}
    };

    String expectedPrintedGrid = "..." + NEW_LINE +
        "..." + NEW_LINE +
        "..." + NEW_LINE + "";

    GridWriter gridWriter = new GridWriter();
    String printedGrid = gridWriter.convertToString(gridContents);
    assertThat(printedGrid, is(expectedPrintedGrid));
  }

  @Test
  public void shouldBeAbleToReadAStringGridContainingLiveAndDeadCells() {
    Cell[][] gridContents = {
        {Cell.LIVE_CELL, Cell.DEAD_CELL, Cell.DEAD_CELL},
        {Cell.DEAD_CELL, Cell.LIVE_CELL, Cell.DEAD_CELL},
        {Cell.DEAD_CELL, Cell.LIVE_CELL, Cell.DEAD_CELL}
    };

    String expectedPrintedGrid = "*.." + NEW_LINE +
        ".*." + NEW_LINE +
        ".*." + NEW_LINE + "";

    GridWriter gridWriter = new GridWriter();
    String printedGrid = gridWriter.convertToString(gridContents);
    assertThat(printedGrid, is(expectedPrintedGrid));
  }

  @Test
  public void shouldBeAbleToReadALargeStringGridContainingLiveAndDeadCells() {
    Cell[][] gridContents = {
        {Cell.LIVE_CELL, Cell.DEAD_CELL, Cell.DEAD_CELL, Cell.LIVE_CELL, Cell.DEAD_CELL, Cell.DEAD_CELL, Cell.LIVE_CELL, Cell.DEAD_CELL, Cell.DEAD_CELL, Cell.LIVE_CELL, Cell.DEAD_CELL, Cell.DEAD_CELL},
        {Cell.DEAD_CELL, Cell.LIVE_CELL, Cell.DEAD_CELL, Cell.DEAD_CELL, Cell.LIVE_CELL, Cell.DEAD_CELL, Cell.DEAD_CELL, Cell.LIVE_CELL, Cell.DEAD_CELL, Cell.DEAD_CELL, Cell.LIVE_CELL, Cell.DEAD_CELL},
        {Cell.DEAD_CELL, Cell.LIVE_CELL, Cell.DEAD_CELL, Cell.DEAD_CELL, Cell.LIVE_CELL, Cell.DEAD_CELL, Cell.DEAD_CELL, Cell.LIVE_CELL, Cell.DEAD_CELL, Cell.DEAD_CELL, Cell.LIVE_CELL, Cell.DEAD_CELL},
        {Cell.LIVE_CELL, Cell.DEAD_CELL, Cell.DEAD_CELL, Cell.LIVE_CELL, Cell.DEAD_CELL, Cell.DEAD_CELL, Cell.LIVE_CELL, Cell.DEAD_CELL, Cell.DEAD_CELL, Cell.LIVE_CELL, Cell.DEAD_CELL, Cell.DEAD_CELL},
        {Cell.DEAD_CELL, Cell.LIVE_CELL, Cell.DEAD_CELL, Cell.DEAD_CELL, Cell.LIVE_CELL, Cell.DEAD_CELL, Cell.DEAD_CELL, Cell.LIVE_CELL, Cell.DEAD_CELL, Cell.DEAD_CELL, Cell.LIVE_CELL, Cell.DEAD_CELL},
        {Cell.DEAD_CELL, Cell.LIVE_CELL, Cell.DEAD_CELL, Cell.DEAD_CELL, Cell.LIVE_CELL, Cell.DEAD_CELL, Cell.DEAD_CELL, Cell.LIVE_CELL, Cell.DEAD_CELL, Cell.DEAD_CELL, Cell.LIVE_CELL, Cell.DEAD_CELL},
        {Cell.LIVE_CELL, Cell.DEAD_CELL, Cell.DEAD_CELL, Cell.LIVE_CELL, Cell.DEAD_CELL, Cell.DEAD_CELL, Cell.LIVE_CELL, Cell.DEAD_CELL, Cell.DEAD_CELL, Cell.LIVE_CELL, Cell.DEAD_CELL, Cell.DEAD_CELL},
        {Cell.DEAD_CELL, Cell.LIVE_CELL, Cell.DEAD_CELL, Cell.DEAD_CELL, Cell.LIVE_CELL, Cell.DEAD_CELL, Cell.DEAD_CELL, Cell.LIVE_CELL, Cell.DEAD_CELL, Cell.DEAD_CELL, Cell.LIVE_CELL, Cell.DEAD_CELL},
        {Cell.DEAD_CELL, Cell.LIVE_CELL, Cell.DEAD_CELL, Cell.DEAD_CELL, Cell.LIVE_CELL, Cell.DEAD_CELL, Cell.DEAD_CELL, Cell.LIVE_CELL, Cell.DEAD_CELL, Cell.DEAD_CELL, Cell.LIVE_CELL, Cell.DEAD_CELL},
        {Cell.LIVE_CELL, Cell.DEAD_CELL, Cell.DEAD_CELL, Cell.LIVE_CELL, Cell.DEAD_CELL, Cell.DEAD_CELL, Cell.LIVE_CELL, Cell.DEAD_CELL, Cell.DEAD_CELL, Cell.LIVE_CELL, Cell.DEAD_CELL, Cell.DEAD_CELL},
        {Cell.DEAD_CELL, Cell.LIVE_CELL, Cell.DEAD_CELL, Cell.DEAD_CELL, Cell.LIVE_CELL, Cell.DEAD_CELL, Cell.DEAD_CELL, Cell.LIVE_CELL, Cell.DEAD_CELL, Cell.DEAD_CELL, Cell.LIVE_CELL, Cell.DEAD_CELL},
        {Cell.DEAD_CELL, Cell.LIVE_CELL, Cell.DEAD_CELL, Cell.DEAD_CELL, Cell.LIVE_CELL, Cell.DEAD_CELL, Cell.DEAD_CELL, Cell.LIVE_CELL, Cell.DEAD_CELL, Cell.DEAD_CELL, Cell.LIVE_CELL, Cell.DEAD_CELL},
    };

    String expectedPrintedGrid = "*..*..*..*.." + NEW_LINE +
        ".*..*..*..*." + NEW_LINE +
        ".*..*..*..*." + NEW_LINE +
        "*..*..*..*.." + NEW_LINE +
        ".*..*..*..*." + NEW_LINE +
        ".*..*..*..*." + NEW_LINE +
        "*..*..*..*.." + NEW_LINE +
        ".*..*..*..*." + NEW_LINE +
        ".*..*..*..*." + NEW_LINE +
        "*..*..*..*.." + NEW_LINE +
        ".*..*..*..*." + NEW_LINE +
        ".*..*..*..*." + NEW_LINE + "";

    GridWriter gridWriter = new GridWriter();
    String printedGrid = gridWriter.convertToString(gridContents);
    assertThat(printedGrid, is(expectedPrintedGrid));
  }

}
