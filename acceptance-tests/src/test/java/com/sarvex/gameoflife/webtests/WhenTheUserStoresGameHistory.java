package com.sarvex.gameoflife.webtests;

import net.thucydides.core.annotations.WithTag;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(ThucydidesRunner.class)

@WithTag("Storing simulation history")
public class WhenTheUserStoresGameHistory {

    @Test
    public void aUserShouldBeAbleToSaveASimulationForFutureUse() {}

    @Test
    public void aUserShouldBeAbleToListAllTheSavedSimulations() {}

    @Test
    public void aUserShouldBeAbleToReplayAStoredSimulation() {}
}
