package br.ifrn.semadec.services.team.update;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.dtos.team.input.TeamInput;
import br.ifrn.semadec.entities.score.Score;
import br.ifrn.semadec.entities.team.Team;
import br.ifrn.semadec.entities.team.TeamId;
import br.ifrn.semadec.exceptions.not_found.TeamNotFoundException;
import br.ifrn.semadec.repositories.TeamRepository;

@Service
public class UpdateTeam {

    @Autowired
    private static TeamRepository teamRepository;

    private UpdateTeam() {
        throw new IllegalStateException("Service class");
    }

    public static Team execute(final TeamId teamId, TeamInput input) {
        return teamRepository.findById(teamId)
                .map(team -> _convertInOutput(team, input))
                .map(teamRepository::save)
                .orElseThrow(TeamNotFoundException::new);
    }

    private static Team _convertInOutput(Team team, TeamInput input) {
        Score score = _builderScore(input.getScoreInstance());
        team.setScoreInstance(score);

        return team;
    }

    private static Score _builderScore(Number number) {
        return Score.builder()
                .number(number)
                .build();
    }

}
