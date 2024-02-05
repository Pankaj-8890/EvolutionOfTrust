import org.example.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CopyCatPlayerTest {

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

}
