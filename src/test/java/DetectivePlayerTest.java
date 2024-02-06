import org.example.Action;
import org.example.DetectivePlayer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DetectivePlayerTest {

    @Test
    public void TestDetectivePlayerInitialRound() {
        DetectivePlayer detectivePlayer = new DetectivePlayer();

        assertEquals(Action.COOPERATE, detectivePlayer.takeAction());
    }

    @Test
    public void TestDetectivePlayerSecondRound() {
        DetectivePlayer detectivePlayer = new DetectivePlayer();

        assertEquals(Action.COOPERATE, detectivePlayer.takeAction());
        assertEquals(Action.CHEAT, detectivePlayer.takeAction());
    }

    @Test
    public void TestDetectivePlayerWhenGotCooperateInBetween() {

        DetectivePlayer detectivePlayer = new DetectivePlayer();

        assertEquals(Action.COOPERATE, detectivePlayer.takeAction());
        assertEquals(Action.CHEAT, detectivePlayer.takeAction());
        assertEquals(Action.CHEAT, detectivePlayer.takeAction());
        assertEquals(Action.CHEAT, detectivePlayer.takeAction());

    }

    @Test
    public void TestDetectivePlayerWhenGotCheatInBetween() {

        DetectivePlayer detectivePlayer = new DetectivePlayer();

        assertEquals(Action.COOPERATE, detectivePlayer.takeAction());
        assertEquals(Action.CHEAT, detectivePlayer.takeAction());
        detectivePlayer.invest();
        assertEquals(Action.CHEAT, detectivePlayer.takeAction());
        detectivePlayer.gain();
        assertEquals(Action.COOPERATE, detectivePlayer.takeAction());

    }

}
