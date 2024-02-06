import org.example.Action;
import org.example.CopyCatPlayer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CopyCatPlayerTest {
    @Test
    public void TestCopyCatPlayerIsCreated() {
        CopyCatPlayer copyCatPlayer = new CopyCatPlayer();
        assertEquals(Action.CHEAT,copyCatPlayer.takeAction());
    }

    @Test
    public void TestCopyCatPlayerActionChangeWhenLastGainIsTrue(){
        CopyCatPlayer copyCatPlayer = new CopyCatPlayer();
        copyCatPlayer.gain();
        assertEquals(Action.COOPERATE,copyCatPlayer.takeAction());
    }

    @Test
    public void TestCopyCatPlayerActionChangeWhenLastInvestisTrue(){
        CopyCatPlayer copyCatPlayer = new CopyCatPlayer();
        copyCatPlayer.invest();
        assertEquals(Action.CHEAT,copyCatPlayer.takeAction());
    }

}
