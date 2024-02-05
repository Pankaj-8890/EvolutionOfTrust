import org.example.Behaviour;
import org.example.EvolutionOfTrust;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EvolutionOfTrustTest {

    @Test
    public void TestGameWhenFirstPlayerCooperateAndSecondPlayerCheat() {
        EvolutionOfTrust evolutionOfTrust = new EvolutionOfTrust();
        int result = evolutionOfTrust.startGame(Behaviour.COOPERATE,Behaviour.CHEAT);
        assertEquals(1,result);
    }
    @Test
    public void TestGameWhenFirstPlayerCooperateAndSecondPlayerCooperate() {
        EvolutionOfTrust evolutionOfTrust = new EvolutionOfTrust();
        int result = evolutionOfTrust.startGame(Behaviour.COOPERATE,Behaviour.COOPERATE);
        assertEquals(2,result);
    }
    @Test
    public void TestGameWhenFirstPlayerCheatAndSecondPlayerCheat() {
        EvolutionOfTrust evolutionOfTrust = new EvolutionOfTrust();
        int result = evolutionOfTrust.startGame(Behaviour.CHEAT,Behaviour.CHEAT);
        assertEquals(0,result);
    }
    @Test
    public void TestGameWhenFirstPlayerCheatAndSecondPlayerCooperate() {
        EvolutionOfTrust evolutionOfTrust = new EvolutionOfTrust();
        int result = evolutionOfTrust.startGame(Behaviour.CHEAT,Behaviour.COOPERATE);
        assertEquals(3,result);
    }
}
