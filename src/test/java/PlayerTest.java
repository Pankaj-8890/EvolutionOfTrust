import org.example.Behaviour;
import org.example.Player;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PlayerTest {
    @Test
    public void TestPlayerIsCreated() {
        assertDoesNotThrow(()-> new Player());
    }


}
