import org.example.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TrustMachineTest {
    @Test
    public void TestWhenCooperatePlayerMatchWithCheatPlayer() {
        CooperatePlayer firstPlayer = new CooperatePlayer();
        CheatPlayer secondPlayer = new CheatPlayer();

        TrustMachine trustMachine = new TrustMachine(firstPlayer,secondPlayer);
        trustMachine.TrustTransaction(1);
        assertEquals(secondPlayer,trustMachine.getResults());
    }
    @Test
    public void TestWhenCheatPlayerMatchWithCheatPlayer() {
        CheatPlayer firstPlayer = new CheatPlayer();
        CheatPlayer secondPlayer = new CheatPlayer();

        TrustMachine trustMachine = new TrustMachine(firstPlayer,secondPlayer);
        trustMachine.TrustTransaction(1);

        assertNull(trustMachine.getResults());

    }

    @Test
    public void TestWhenCheatPlayerMatchWithCheatPlayerin2Rounds() {
        CheatPlayer firstPlayer = new CheatPlayer();
        CheatPlayer secondPlayer = new CheatPlayer();

        TrustMachine trustMachine = new TrustMachine(firstPlayer,secondPlayer);
        trustMachine.TrustTransaction(2);

        assertNull(trustMachine.getResults());

    }

    @Test
    public void TestWhenCooperatePlayerMatchWithCooperatePlayer() {
        CooperatePlayer firstPlayer = new CooperatePlayer();
        CooperatePlayer secondPlayer = new CooperatePlayer();

        TrustMachine trustMachine = new TrustMachine(firstPlayer,secondPlayer);
        trustMachine.TrustTransaction(1);

        assertNull(trustMachine.getResults());

    }

    @Test
    public void TestWhenCooperatePlayerMatchWithCooperatePlayerin2Rounds() {
        CooperatePlayer firstPlayer = new CooperatePlayer();
        CooperatePlayer secondPlayer = new CooperatePlayer();

        TrustMachine trustMachine = new TrustMachine(firstPlayer,secondPlayer);
        trustMachine.TrustTransaction(2);

        assertNull(trustMachine.getResults());

    }

    @Test
    public void TestWhenCheatPlayerMatchWithCooperatePlayer() {
        CheatPlayer firstPlayer = new CheatPlayer();
        CooperatePlayer secondPlayer = new CooperatePlayer();

        TrustMachine trustMachine = new TrustMachine(firstPlayer,secondPlayer);
        trustMachine.TrustTransaction(1);

        assertEquals(firstPlayer,trustMachine.getResults());

    }

    @Test
    public void TestActionWhenCopycatPlayerInitialMove() {
        CopyCatPlayer player = new CopyCatPlayer();
        assertEquals(Action.CHEAT, player.takeAction());
    }

    @Test
    public void TestWinnerWhenCopycatPlayerMatchWithCooperatePlayerInFirstRound() {
        CopyCatPlayer copyCatPlayer = new CopyCatPlayer();
        CooperatePlayer cooperatePlayer = new CooperatePlayer();
        TrustMachine trustMachine = new TrustMachine(copyCatPlayer,cooperatePlayer);
        trustMachine.TrustTransaction(1);
        assertEquals(copyCatPlayer, trustMachine.getResults());
    }

    @Test
    public void TestWinnerWhenCopycatPlayerMatchWithCooperatePlayerInSecondRound() {
        CopyCatPlayer copyCatPlayer = new CopyCatPlayer();
        CooperatePlayer cooperatePlayer = new CooperatePlayer();
        TrustMachine trustMachine = new TrustMachine(copyCatPlayer,cooperatePlayer);
        trustMachine.TrustTransaction(2);
        assertEquals(copyCatPlayer, trustMachine.getResults());
    }


    @Test
    public void TestWinnerWhenCopycatPlayerSecondMoveWithCheatPlayer() {
        CopyCatPlayer copyCatPlayer = new CopyCatPlayer();
        CheatPlayer cheatPlayer = new CheatPlayer();
        TrustMachine trustMachine = new TrustMachine(copyCatPlayer,cheatPlayer);
        trustMachine.TrustTransaction(2);
        assertNull(trustMachine.getResults());
    }

    @Test
    public void transactionBetweenCopycatAndCooperatePlayer() {
        CopyCatPlayer copyCatPlayer = new CopyCatPlayer();
        CooperatePlayer cooperatePlayer = new CooperatePlayer();
        TrustMachine trustMachine = new TrustMachine(copyCatPlayer, cooperatePlayer);
        trustMachine.TrustTransaction(5);
        assertEquals(copyCatPlayer, trustMachine.getResults());
    }

    @Test
    public void copycatPlayerInitialMove() {
        CopyKittenPlayer player = new CopyKittenPlayer();

        assertEquals(Action.COOPERATE, player.takeAction());
    }

    @Test
    public void copycatPlayerSecondMoveWithCooperatePlayerInRound1() {
        CopyKittenPlayer copyKittenPlayer = new CopyKittenPlayer();
        CooperatePlayer cooperatePlayer = new CooperatePlayer();
        TrustMachine trustMachine = new TrustMachine(copyKittenPlayer, cooperatePlayer);

        trustMachine.TrustTransaction(1);

        assertNull(trustMachine.getResults());
    }

    @Test
    public void copycatPlayerSecondMoveWithCooperatePlayerInRound2() {
        CopyKittenPlayer copyKittenPlayer = new CopyKittenPlayer();
        CooperatePlayer cooperatePlayer = new CooperatePlayer();
        TrustMachine trustMachine = new TrustMachine(copyKittenPlayer, cooperatePlayer);

        trustMachine.TrustTransaction(2);

        assertNull(trustMachine.getResults());
    }

    @Test
    public void copycatPlayerSecondMoveWithCheatPlayer() {
        CopyKittenPlayer copyKittenPlayer = new CopyKittenPlayer();
        CheatPlayer cheatPlayer = new CheatPlayer();
        TrustMachine trustMachine = new TrustMachine(copyKittenPlayer, cheatPlayer);

        trustMachine.TrustTransaction(2);

        assertEquals(cheatPlayer, trustMachine.getResults());
    }

}
