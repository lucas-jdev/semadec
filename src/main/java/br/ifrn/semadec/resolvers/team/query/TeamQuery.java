package br.ifrn.semadec.resolvers.team.query;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import br.ifrn.semadec.dtos.team.input.TeamIdInput;
import br.ifrn.semadec.entities.team.Team;
import br.ifrn.semadec.services.team.read.ReadAllTeams;
import br.ifrn.semadec.services.team.read.ReadTeamById;

@Controller
public class TeamQuery {

    @QueryMapping
    public Team findById(TeamIdInput id) {
        return ReadTeamById.execute(id);
    }

    @QueryMapping
    public Iterable<Team> findAll() {
        return ReadAllTeams.execute();
    }

}
