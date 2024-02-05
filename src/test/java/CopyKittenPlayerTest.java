import org.example.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CopyKittenPlayerTest {
    @Test
    public void copycatPlayerInitialMove() {
        CopyKittenPlayer player = new CopyKittenPlayer();

        assertEquals(Action.COOPERATE, player.takeAction());
    }

    @Test
    public void copycatPlayerSecondMoveWithCooperatePlayer() {
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
