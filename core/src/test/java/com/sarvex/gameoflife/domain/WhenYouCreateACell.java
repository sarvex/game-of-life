package com.sarvex.gameoflife.domain;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class WhenYouCreateACell {

  @Test
  public void aLiveCellShouldBeRepresentedByAnAsterisk() {
    Cell cell = Cell.fromSymbol("*");
    assertThat(cell, Matchers.is(Cell.LIVE_CELL));
  }

  @Test
  public void aDeadCellShouldBeRepresentedByADot() {
    Cell cell = Cell.fromSymbol(".");
    assertThat(cell, Matchers.is(Cell.DEAD_CELL));
  }

  @Test
  public void aLiveCellShouldBePrintedAsAnAsterisk() {
    assertThat(Cell.LIVE_CELL.toString(), is("*"));
  }


  @Test
  public void aDeadCellShouldBePrintedAsADot() {
    assertThat(Cell.DEAD_CELL.toString(), is("."));
  }

  @Test
  public void aDeadCellSymbolShouldBeADot() {
    assertThat(Cell.DEAD_CELL.getSymbol(), is("."));
  }

  @Test
  public void aLiveCellSymbolShouldBeAnAsterisk() {
    assertThat(Cell.LIVE_CELL.getSymbol(), is("*"));
  }

}
