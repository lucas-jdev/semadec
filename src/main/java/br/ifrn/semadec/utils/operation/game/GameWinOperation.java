package br.ifrn.semadec.utils.operation.game;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import br.ifrn.semadec.entities.game.Game;
import br.ifrn.semadec.entities.team.Team;

public class GameWinOperation {

    private GameWinOperation() {
        throw new IllegalStateException("Utility class");
    }

    public static Collection<Team> getWinners(Game game) {
        List<Team> teams = game.getTeams();

        Comparator<Team> comparator = (t1, t2) -> {
            Number scoreTeam = t1.getScoreInstance().getNumber();
            Number scoreOtherTeam = t2.getScoreInstance().getNumber();
            return scoreTeam.intValue() - scoreOtherTeam.intValue();
        };

        teams.sort(comparator);

        return teams;
    }
}
