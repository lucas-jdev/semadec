package br.ifrn.semadec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifrn.semadec.entities.team.Team;
import br.ifrn.semadec.entities.team.TeamId;

public interface TeamRepository extends JpaRepository<Team, TeamId> {

    // TODO: implementar métodos de busca

}
