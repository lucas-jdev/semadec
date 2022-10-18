package br.ifrn.semadec.services.team.create;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.dtos.team.input.TeamInput;
import br.ifrn.semadec.entities.team.Team;
import br.ifrn.semadec.entities.team.TeamId;
import br.ifrn.semadec.repositories.TeamRepository;

@Service
public class CreateTeam {

    @Autowired
    private static TeamRepository teamRepository;

    private CreateTeam() {
        throw new IllegalStateException("Service class");
    }

    // public static Team execute(final TeamInput input) {

    // return teamRepository.save(team);
    // }

}
