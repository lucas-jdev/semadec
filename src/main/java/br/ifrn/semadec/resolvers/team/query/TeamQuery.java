package br.ifrn.semadec.resolvers.team.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import br.ifrn.semadec.dtos.team.input.TeamIdInput;
import br.ifrn.semadec.entities.team.Team;
import br.ifrn.semadec.services.team.read.ReadAllTeams;
import br.ifrn.semadec.services.team.read.ReadTeamById;

@Controller
public class TeamQuery {

    @Autowired
    private ReadAllTeams readAllTeams;

    @Autowired
    private ReadTeamById readTeamById;

    @QueryMapping
    public Team findById(TeamIdInput id) {
        return readTeamById.execute(id);
    }

    @QueryMapping
    public Iterable<Team> findAll() {
        return readAllTeams.execute();
    }

}
