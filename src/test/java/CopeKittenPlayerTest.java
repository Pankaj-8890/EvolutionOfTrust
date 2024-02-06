import org.example.Action;
import org.example.CopyCatPlayer;
import org.example.CopyKittenPlayer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CopeKittenPlayerTest {
    @Test
    public void TestCopyKittenPlayerIsCreated() {
        CopyKittenPlayer copyKittenPlayer = new CopyKittenPlayer();
        assertEquals(Action.COOPERATE,copyKittenPlayer.takeAction());
    }

    @Test
    public void TestCopyKittenPlayerActionChangeWhenLastGainIsTrue(){
        CopyKittenPlayer copyKittenPlayer = new CopyKittenPlayer();
        copyKittenPlayer.gain();
        assertEquals(Action.COOPERATE,copyKittenPlayer.takeAction());
    }

    @Test
    public void TestCopyKittenPlayerActionChangeWhenLastInvestisTrue(){
        CopyKittenPlayer copyKittenPlayer = new CopyKittenPlayer();
        copyKittenPlayer.invest();
        assertEquals(Action.CHEAT,copyKittenPlayer.takeAction());
    }
}
