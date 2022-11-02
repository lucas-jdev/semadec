package br.ifrn.semadec.resolvers.team.mutation;

import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import br.ifrn.semadec.dtos.team.input.TeamInput;
import br.ifrn.semadec.entities.team.Team;
import br.ifrn.semadec.entities.team.TeamId;
import br.ifrn.semadec.services.team.create.CreateTeam;
import br.ifrn.semadec.services.team.update.UpdateTeam;

@Controller
public class TeamMutation {

    @MutationMapping
    public Team createTeam(TeamInput input) {
        return CreateTeam.excute(input);
    }

    @MutationMapping
    public Team updateTeam(TeamId id, TeamInput input) {
        return UpdateTeam.execute(id, input);
    }

}
