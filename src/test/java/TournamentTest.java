import org.example.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TournamentTest {

    @Test
    public void TestAllPlayerAreNotSameInTournament() throws Exception {
        Player player1 = new CheatPlayer();
        Player player2 = new CheatPlayer();
        Player player3 = new CheatPlayer();
        Player player4 = new CheatPlayer();
        Player player5 = new CooperatePlayer();
        Tournament tournament = new Tournament();
        tournament.add(player1);
        tournament.add(player2);
        tournament.add(player3);
        tournament.add(player4);
        tournament.add(player5);

        tournament.startTournament(5);
        assertTrue(tournament.checkAllPlayerSame());
    }

    @Test
    public void TestAtTheEndOfTournamentAllPlayerShouldBeSame() throws Exception {
        Player player1 = spy(new CheatPlayer());
        Player player2 = spy(new CheatPlayer());
        Player player3 = spy(new CheatPlayer());
        Player player4 = spy(new CheatPlayer());
        Player player5 = spy(new CooperatePlayer());
        Tournament tournament = new Tournament();
        tournament.add(player1);
        tournament.add(player2);
        tournament.add(player3);
        tournament.add(player4);
        tournament.add(player5);

        tournament.startTournament(1);
        verify(player1, times(1)).gain();
        verify(player1, times(0)).invest();
        verify(player2, times(1)).gain();
        verify(player2, times(0)).invest();
        verify(player3, times(1)).gain();
        verify(player3, times(0)).invest();
        verify(player4, times(1)).gain();
        verify(player4, times(0)).invest();
        verify(player5, times(0)).gain();
        verify(player5, times(4)).invest();
    }

    @Test
    public void TestAtTheEndOfTournamentCheatWillWin() throws Exception {
        Player player1 = spy(new CheatPlayer());
        Player player2 = spy(new CooperatePlayer());
        Player player3 = spy(new CooperatePlayer());
        Player player4 = spy(new CooperatePlayer());
        Player player5 = spy(new CooperatePlayer());
        Tournament tournament = new Tournament();
        tournament.add(player1);
        tournament.add(player2);
        tournament.add(player3);
        tournament.add(player4);
        tournament.add(player5);

        tournament.startTournament(1);
        verify(player1, times(4)).gain();
        verify(player1, times(0)).invest();
        verify(player2, times(3)).gain();
        verify(player2, times(4)).invest();
        verify(player3, times(3)).gain();
        verify(player3, times(4)).invest();
        verify(player4, times(3)).gain();
        verify(player4, times(4)).invest();
        verify(player5, times(3)).gain();
        verify(player5, times(4)).invest();
    }

}
