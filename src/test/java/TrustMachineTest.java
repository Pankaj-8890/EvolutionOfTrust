import org.example.CheatPlayer;
import org.example.CooperatePlayer;
import org.example.TrustMachine;
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
    public void TestWhenCooperatePlayerMatchWithCooperatePlayer() {
        CooperatePlayer firstPlayer = new CooperatePlayer();
        CooperatePlayer secondPlayer = new CooperatePlayer();

        TrustMachine trustMachine = new TrustMachine(firstPlayer,secondPlayer);
        trustMachine.TrustTransaction(1);

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
}
