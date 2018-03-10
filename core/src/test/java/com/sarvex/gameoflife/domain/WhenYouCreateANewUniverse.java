package com.sarvex.gameoflife.domain;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class WhenYouCreateANewUniverse {

  private static final String NEW_LINE = System.getProperty("line.separator");

  private static final String EMPTY_GRID = "....." + NEW_LINE + "....." + NEW_LINE + "....." + NEW_LINE + "....." + NEW_LINE + "....." + NEW_LINE;

  @Test
  public void aNewUniverseShouldContainOnlyDeadCells() {
    Universe theUniverse = new Universe();
    String currentGrid = theUniverse.getGrid();
    assertThat(currentGrid, is(EMPTY_GRID));
  }

  @Test
  public void aUniverseSeededWithAnEmptyGridContentWillContainAnEmptyGrid() {

    String seededGrid = "..." + NEW_LINE + "..." + NEW_LINE + "..." + NEW_LINE + "";

    Universe theUniverse = new Universe(Universe.seededWith(seededGrid));
    String currentGrid = theUniverse.getGrid();
    assertThat(currentGrid, is(seededGrid));
  }

  @Test
  public void aUniverseCanBeInitializedWithAnyDimension() {
    String expectedGrid = "....." + NEW_LINE + "....." + NEW_LINE + "....." + NEW_LINE + "....." + NEW_LINE + "";

    Universe theUniverse = new Universe(4, 5);
    String currentGrid = theUniverse.getGrid();
    assertThat(currentGrid, is(expectedGrid));

  }

  @Test
  public void aUniverseSeededWithAGridContainingASingleLiveCellContentWillSpawnAnEmptyGrid() {

    String seededGrid = "..." + NEW_LINE + ".*." + NEW_LINE + "..." + NEW_LINE + "";

    String expectedGrid = "..." + NEW_LINE + "..." + NEW_LINE + "..." + NEW_LINE + "";

    Universe theUniverse = new Universe(Universe.seededWith(seededGrid));
    theUniverse.spawnsANewGeneration();
    String currentGrid = theUniverse.getGrid();
    assertThat(currentGrid, is(expectedGrid));
  }

  @Test
  public void aUniverseSeededWithAGridWithLivingCellsContentWillContainThatGrid() {

    String seededGrid = "*.." + NEW_LINE + ".*." + NEW_LINE + "..*" + NEW_LINE + "";

    Universe theUniverse = new Universe(Universe.seededWith(seededGrid));
    String currentGrid = theUniverse.getGrid();
    assertThat(currentGrid, is(seededGrid));
  }

  @Test
  public void aUniverseSpawnsANewGridInTheNextGeneration() {

    String seededGrid = "..." + NEW_LINE + "***" + NEW_LINE + "..." + NEW_LINE + "";

    String expectedNextGeneration = ".*." + NEW_LINE + ".*." + NEW_LINE + ".*." + NEW_LINE + "";

    Universe theUniverse = new Universe(Universe.seededWith(seededGrid));
    theUniverse.createNextGeneration();
    String currentGrid = theUniverse.getGrid();
    assertThat(currentGrid, is(expectedNextGeneration));
  }

  @Test
  public void aUserCanAssignALiveCellAtAGivenPointInTheGrid() {
    String seededGrid = "..." + NEW_LINE + "..." + NEW_LINE + "..." + NEW_LINE + "";

    String expectedState = "*.." + NEW_LINE + "*.." + NEW_LINE + ".*." + NEW_LINE + "";

    Universe theUniverse = new Universe(Universe.seededWith(seededGrid));
    theUniverse.setLiveCellAt(0, 0);
    theUniverse.setLiveCellAt(1, 0);
    theUniverse.setLiveCellAt(2, 1);

    assertThat(theUniverse.getGrid(), is(expectedState));
  }

  @Test
  public void aUserCanAssignADeadCellAtAGivenPointInTheGrid() {
    String seededGrid = "***" + NEW_LINE + "***" + NEW_LINE + "***" + NEW_LINE + "";

    String expectedState = "*.*" + NEW_LINE + "***" + NEW_LINE + "***" + NEW_LINE + "";

    Universe theUniverse = new Universe(Universe.seededWith(seededGrid));
    theUniverse.setDeadCellAt(0, 1);
    assertThat(theUniverse.getGrid(), is(expectedState));
  }


  @Test
  public void aUserCanReadALiveCellValueAtAGivenPointInTheGrid() {
    String seededGrid = "*.." + NEW_LINE + "*.." + NEW_LINE + ".*." + NEW_LINE + "";

    Universe theUniverse = new Universe(Universe.seededWith(seededGrid));

    assertThat(theUniverse.getCellAt(0, 0), Matchers.is(Cell.LIVE_CELL));
    assertThat(theUniverse.getCellAt(1, 0), Matchers.is(Cell.LIVE_CELL));
    assertThat(theUniverse.getCellAt(2, 1), Matchers.is(Cell.LIVE_CELL));
  }

  @Test
  public void aUserCanReadADeadCellValueAtAGivenPointInTheGrid() {
    String seededGrid = "*.." + NEW_LINE + "*.." + NEW_LINE + ".*." + NEW_LINE + "";

    Universe theUniverse = new Universe(Universe.seededWith(seededGrid));

    assertThat(theUniverse.getCellAt(0, 1), Matchers.is(Cell.DEAD_CELL));
    assertThat(theUniverse.getCellAt(1, 1), Matchers.is(Cell.DEAD_CELL));
  }

  @Test
  public void aUserCanObtainTheGridContentsAsAnArrayOfCells() {
    String seededGrid = "*.." + NEW_LINE + "*.." + NEW_LINE + ".*." + NEW_LINE + "";
    Universe theUniverse = new Universe(Universe.seededWith(seededGrid));

    Cell[][] expectedCells = new Cell[][]{
        {Cell.LIVE_CELL, Cell.DEAD_CELL, Cell.DEAD_CELL},
        {Cell.LIVE_CELL, Cell.DEAD_CELL, Cell.DEAD_CELL},
        {Cell.DEAD_CELL, Cell.LIVE_CELL, Cell.DEAD_CELL},
    };

    assertThat(theUniverse.getCells(), is(expectedCells));
  }


}
