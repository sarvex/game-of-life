package com.sarvex.gameoflife.domain;

import org.junit.Test;

import static com.sarvex.gameoflife.domain.Cell.DEAD_CELL;
import static com.sarvex.gameoflife.domain.Cell.LIVE_CELL;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class WhenYouReadAGridFromAString {

  private final String NEW_LINE = System.getProperty("line.separator");

  @Test
  public void shouldBeAbleToReadAnEmptyGridOfCellsFromAnEmptyString() {
    String gridContents = "";

    Cell[][] expectedCells = {{}};

    GridReader gridReader = new GridReader();
    Cell[][] loadedCells = gridReader.loadFrom(gridContents);

    assertThat(loadedCells, is(expectedCells));
  }

  @Test
  public void shouldBeAbleToReadAGridContainingASingleCellFromAString() {
    String gridContents = "*";

    Cell[][] expectedCells = {{LIVE_CELL}};

    GridReader gridReader = new GridReader();
    Cell[][] loadedCells = gridReader.loadFrom(gridContents);

    assertThat(loadedCells, is(expectedCells));
  }

  @Test
  public void shouldBeAbleToReadAGridOfCellsFromAString() {
    String gridContents = "..." + NEW_LINE +
        "..." + NEW_LINE +
        "...";

    Cell[][] expectedCells = {
        {DEAD_CELL, DEAD_CELL, DEAD_CELL},
        {DEAD_CELL, DEAD_CELL, DEAD_CELL},
        {DEAD_CELL, DEAD_CELL, DEAD_CELL}
    };

    GridReader gridReader = new GridReader();
    Cell[][] loadedCells = gridReader.loadFrom(gridContents);

    assertThat(loadedCells, is(expectedCells));
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldRefuseIllegalCellCharacters() {
    String gridContents = "..." + NEW_LINE +
        ".Z." + NEW_LINE +
        "...";

    Cell[][] expectedCells = {
        {DEAD_CELL, DEAD_CELL, DEAD_CELL},
        {DEAD_CELL, DEAD_CELL, DEAD_CELL},
        {DEAD_CELL, DEAD_CELL, DEAD_CELL}
    };

    GridReader gridReader = new GridReader();
    Cell[][] loadedCells = gridReader.loadFrom(gridContents);

    assertThat(loadedCells, is(expectedCells));
  }

  @Test
  public void shouldBeAbleToReadAGridContainingLiveAndDeadCells() {
    String gridContents = "*.." + NEW_LINE +
        ".*." + NEW_LINE +
        "..*";

    Cell[][] expectedCells = {
        {LIVE_CELL, DEAD_CELL, DEAD_CELL},
        {DEAD_CELL, LIVE_CELL, DEAD_CELL},
        {DEAD_CELL, DEAD_CELL, LIVE_CELL}
    };

    GridReader gridReader = new GridReader();
    Cell[][] loadedCells = gridReader.loadFrom(gridContents);

    assertThat(loadedCells, is(expectedCells));
  }

  @Test
  public void shouldBeAbleToReadAnAsymmetricalGridContainingLiveAndDeadCells() {
    String gridContents = "...." + NEW_LINE +
        "**.." + NEW_LINE +
        "..*.";

    Cell[][] expectedCells = {
        {DEAD_CELL, DEAD_CELL, DEAD_CELL, DEAD_CELL},
        {LIVE_CELL, LIVE_CELL, DEAD_CELL, DEAD_CELL},
        {DEAD_CELL, DEAD_CELL, LIVE_CELL, DEAD_CELL}
    };

    GridReader gridReader = new GridReader();
    Cell[][] loadedCells = gridReader.loadFrom(gridContents);

    assertThat(loadedCells, is(expectedCells));
  }

  @Test
  public void shouldBeAbleToReadALargerGrid() {
    String gridContents = "......" + NEW_LINE +
        "**...." + NEW_LINE +
        "..*..." + NEW_LINE +
        "..*..." + NEW_LINE +
        "..*..." + NEW_LINE +
        "..*...";

    Cell[][] expectedCells = {
        {DEAD_CELL, DEAD_CELL, DEAD_CELL, DEAD_CELL, DEAD_CELL, DEAD_CELL},
        {LIVE_CELL, LIVE_CELL, DEAD_CELL, DEAD_CELL, DEAD_CELL, DEAD_CELL},
        {DEAD_CELL, DEAD_CELL, LIVE_CELL, DEAD_CELL, DEAD_CELL, DEAD_CELL},
        {DEAD_CELL, DEAD_CELL, LIVE_CELL, DEAD_CELL, DEAD_CELL, DEAD_CELL},
        {DEAD_CELL, DEAD_CELL, LIVE_CELL, DEAD_CELL, DEAD_CELL, DEAD_CELL},
        {DEAD_CELL, DEAD_CELL, LIVE_CELL, DEAD_CELL, DEAD_CELL, DEAD_CELL},
    };

    GridReader gridReader = new GridReader();
    Cell[][] loadedCells = gridReader.loadFrom(gridContents);

    assertThat(loadedCells, is(expectedCells));
  }

  @Test
  public void shouldBeAbleToReadAVeryLargerGrid() {
    String gridContents = "......" + NEW_LINE +
        "**...." + NEW_LINE +
        "..*..." + NEW_LINE +
        "..*..." + NEW_LINE +
        "..*..." + NEW_LINE +
        "..*..." + NEW_LINE +
        "..*..." + NEW_LINE +
        "..*..." + NEW_LINE +
        "..*...";

    Cell[][] expectedCells = {
        {DEAD_CELL, DEAD_CELL, DEAD_CELL, DEAD_CELL, DEAD_CELL, DEAD_CELL},
        {LIVE_CELL, LIVE_CELL, DEAD_CELL, DEAD_CELL, DEAD_CELL, DEAD_CELL},
        {DEAD_CELL, DEAD_CELL, LIVE_CELL, DEAD_CELL, DEAD_CELL, DEAD_CELL},
        {DEAD_CELL, DEAD_CELL, LIVE_CELL, DEAD_CELL, DEAD_CELL, DEAD_CELL},
        {DEAD_CELL, DEAD_CELL, LIVE_CELL, DEAD_CELL, DEAD_CELL, DEAD_CELL},
        {DEAD_CELL, DEAD_CELL, LIVE_CELL, DEAD_CELL, DEAD_CELL, DEAD_CELL},
        {DEAD_CELL, DEAD_CELL, LIVE_CELL, DEAD_CELL, DEAD_CELL, DEAD_CELL},
        {DEAD_CELL, DEAD_CELL, LIVE_CELL, DEAD_CELL, DEAD_CELL, DEAD_CELL},
        {DEAD_CELL, DEAD_CELL, LIVE_CELL, DEAD_CELL, DEAD_CELL, DEAD_CELL},
    };

    GridReader gridReader = new GridReader();
    Cell[][] loadedCells = gridReader.loadFrom(gridContents);

    assertThat(loadedCells, is(expectedCells));
  }
}
