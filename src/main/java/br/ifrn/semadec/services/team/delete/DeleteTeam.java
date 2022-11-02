package br.ifrn.semadec.services.team.delete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.entities.team.TeamId;
import br.ifrn.semadec.repositories.TeamRepository;

@Service
public class DeleteTeam {

    @Autowired
    private static TeamRepository teamRepository;

    private DeleteTeam() {
        throw new IllegalStateException("Service class");
    }

    public static void execute(final TeamId teamId) {
        teamRepository.deleteById(teamId);
    }

}
