import org.example.Action;
import org.example.GrudgePlayer;
import org.example.Player;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GrudgePlayerTest {
    @Test
    public void TestExpectCooperateAsChoiceAfterOneGainAndInvest() {
        GrudgePlayer grudgePlayer = new GrudgePlayer();

        grudgePlayer.gain();
        grudgePlayer.invest();

        assertEquals(Action.COOPERATE, grudgePlayer.takeAction());
    }

    @Test
    public void TestExpectCheatAsChoiceAfterOneInvest() {
        GrudgePlayer grudgePlayer = new GrudgePlayer();

        grudgePlayer.invest();

        assertEquals(Action.CHEAT, grudgePlayer.takeAction());
    }
}
