import org.example.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

public class TrustMachineTest {
    @Test
    public void TestWhenCooperatePlayerMatchWithCheatPlayer() {
        Player firstPlayer = new CooperatePlayer();
        Player secondPlayer = new CheatPlayer();

        TrustMachine trustMachine = new TrustMachine(firstPlayer,secondPlayer);
        trustMachine.TrustTransaction(1);
        assertEquals(secondPlayer,trustMachine.getResults());
    }
    @Test
    public void TestWhenCheatPlayerMatchWithCheatPlayer() {
        Player firstPlayer = new CheatPlayer();
        Player secondPlayer = new CheatPlayer();

        TrustMachine trustMachine = new TrustMachine(firstPlayer,secondPlayer);
        trustMachine.TrustTransaction(1);

        assertNull(trustMachine.getResults());

    }

    @Test
    public void TestWhenCheatPlayerMatchWithCheatPlayerin2Rounds() {
        Player firstPlayer = new CheatPlayer();
        Player secondPlayer = new CheatPlayer();

        TrustMachine trustMachine = new TrustMachine(firstPlayer,secondPlayer);
        trustMachine.TrustTransaction(2);

        assertNull(trustMachine.getResults());

    }

    @Test
    public void TestWhenCooperatePlayerMatchWithCooperatePlayer() {
        Player firstPlayer = new CooperatePlayer();
        Player secondPlayer = new CooperatePlayer();

        TrustMachine trustMachine = new TrustMachine(firstPlayer,secondPlayer);
        trustMachine.TrustTransaction(1);

        assertNull(trustMachine.getResults());

    }

    @Test
    public void TestWhenCooperatePlayerMatchWithCooperatePlayerin2Rounds() {
        Player firstPlayer = new CooperatePlayer();
        Player secondPlayer = new CooperatePlayer();

        TrustMachine trustMachine = new TrustMachine(firstPlayer,secondPlayer);
        trustMachine.TrustTransaction(2);

        assertNull(trustMachine.getResults());

    }

    @Test
    public void TestWhenCheatPlayerMatchWithCooperatePlayer() {
        Player firstPlayer = new CheatPlayer();
        Player secondPlayer = new CooperatePlayer();

        TrustMachine trustMachine = new TrustMachine(firstPlayer,secondPlayer);
        trustMachine.TrustTransaction(1);

        assertEquals(firstPlayer,trustMachine.getResults());

    }

    @Test
    public void TestActionWhenCopycatPlayerInitialMove() {
        Player player = new CopyCatPlayer();
        assertEquals(Action.CHEAT, player.takeAction());
    }

    @Test
    public void TestWinnerWhenCopycatPlayerMatchWithCooperatePlayerInFirstRound() {
        Player copyCatPlayer = new CopyCatPlayer();
        Player cooperatePlayer = new CooperatePlayer();
        TrustMachine trustMachine = new TrustMachine(copyCatPlayer,cooperatePlayer);
        trustMachine.TrustTransaction(1);
        assertEquals(copyCatPlayer, trustMachine.getResults());
    }

    @Test
    public void TestWinnerWhenCopycatPlayerMatchWithCooperatePlayerInSecondRound() {
        Player copyCatPlayer = new CopyCatPlayer();
        Player cooperatePlayer = new CooperatePlayer();
        TrustMachine trustMachine = new TrustMachine(copyCatPlayer,cooperatePlayer);
        trustMachine.TrustTransaction(2);
        assertEquals(copyCatPlayer, trustMachine.getResults());
    }


    @Test
    public void TestWinnerWhenCopycatPlayerSecondMoveWithCheatPlayer() {
        Player copyCatPlayer = new CopyCatPlayer();
        Player cheatPlayer = new CheatPlayer();
        TrustMachine trustMachine = new TrustMachine(copyCatPlayer,cheatPlayer);
        trustMachine.TrustTransaction(2);
        assertNull(trustMachine.getResults());
    }

    @Test
    public void transactionBetweenCopycatAndCooperatePlayer() {
        Player copyCatPlayer = new CopyCatPlayer();
        Player cooperatePlayer = new CooperatePlayer();
        TrustMachine trustMachine = new TrustMachine(copyCatPlayer, cooperatePlayer);
        trustMachine.TrustTransaction(5);
        assertEquals(copyCatPlayer, trustMachine.getResults());
    }

    @Test
    public void TestCopycatPlayerInitialMove() {
        Player player = new CopyKittenPlayer();

        assertEquals(Action.COOPERATE, player.takeAction());
    }

    @Test
    public void TestCopycatPlayerSecondMoveWithCooperatePlayerInRound1() {
        Player copyKittenPlayer = new CopyKittenPlayer();
        Player cooperatePlayer = new CooperatePlayer();
        TrustMachine trustMachine = new TrustMachine(copyKittenPlayer, cooperatePlayer);

        trustMachine.TrustTransaction(1);

        assertNull(trustMachine.getResults());
    }

    @Test
    public void TestCopycatPlayerSecondMoveWithCooperatePlayerInRound2() {
        Player copyKittenPlayer = new CopyKittenPlayer();
        Player cooperatePlayer = new CooperatePlayer();
        TrustMachine trustMachine = new TrustMachine(copyKittenPlayer, cooperatePlayer);

        trustMachine.TrustTransaction(2);

        assertNull(trustMachine.getResults());
    }

    @Test
    public void TestcopycatPlayerSecondMoveWithCheatPlayer() {
        Player copyKittenPlayer = new CopyKittenPlayer();
        Player cheatPlayer = new CheatPlayer();
        TrustMachine trustMachine = new TrustMachine(copyKittenPlayer, cheatPlayer);

        trustMachine.TrustTransaction(2);

        assertEquals(cheatPlayer, trustMachine.getResults());
    }


    @Test
    public void TestExpectDetectivePlayerToCheatInRound3() {
        Player detectivePlayer = new DetectivePlayer();
        Player cooperatePlayer = new CooperatePlayer();
        TrustMachine trustMachine = new TrustMachine(detectivePlayer, cooperatePlayer);

        trustMachine.TrustTransaction(3);

        assertEquals(detectivePlayer, trustMachine.getResults());
    }

    @Test
    public void TestExpectDetectivePlayerToCheatInRound3WithCheatPlayer() {
        Player detectivePlayer = spy( new DetectivePlayer());
        Player cheatPlayer = spy(new CheatPlayer());
        TrustMachine trustMachine = new TrustMachine(detectivePlayer, cheatPlayer);

        trustMachine.TrustTransaction(3);

        verify(detectivePlayer, times(1)).invest();
        verify(detectivePlayer, times(0)).gain();
        verify(cheatPlayer, times(0)).invest();
        verify(cheatPlayer, times(1)).gain();
    }

    @Test
    public void expectDetectivePlayerToCheatInRound4WithCopyCatPlayer() {
        Player detectivePlayer = spy( new DetectivePlayer());
        Player copyCatPlayer = spy(new CopyCatPlayer());
        TrustMachine trustMachine = new TrustMachine(detectivePlayer, copyCatPlayer);

        trustMachine.TrustTransaction(4);

        verify(detectivePlayer, times(2)).invest();
        verify(detectivePlayer, times(2)).gain();
        verify(copyCatPlayer, times(2)).invest();
        verify(copyCatPlayer, times(2)).gain();
    }

    @Test
    public void detectivePlayerTransactionWithCopyKittenPlayer() {
        Player detectivePlayer = spy(new DetectivePlayer());
        Player copyKitten = spy(new CopyKittenPlayer());
        TrustMachine trustMachine = new TrustMachine(detectivePlayer, copyKitten);

        trustMachine.TrustTransaction(4);

        verify(detectivePlayer, times(2)).gain();
        verify(detectivePlayer, times(1)).invest();
        verify(copyKitten, times(2)).invest();
        verify(copyKitten, times(1)).gain();
    }

}
