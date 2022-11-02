package br.ifrn.semadec.services.team.read;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.entities.team.Team;
import br.ifrn.semadec.repositories.TeamRepository;

@Service
public class ReadAllTeams {

    @Autowired
    private static TeamRepository teamRepository;

    private ReadAllTeams() {
        throw new IllegalStateException("Service class");
    }

    public static Collection<Team> execute() {
        return teamRepository.findAll();
    }

}
