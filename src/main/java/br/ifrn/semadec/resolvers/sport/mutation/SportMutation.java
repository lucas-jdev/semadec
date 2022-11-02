package br.ifrn.semadec.resolvers.sport.mutation;

import java.util.UUID;

import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import br.ifrn.semadec.dtos.sport.input.SportInput;
import br.ifrn.semadec.entities.sport.Sport;
import br.ifrn.semadec.services.sport.create.CreateSport;
import br.ifrn.semadec.services.sport.update.UpdateSport;

@Controller
public class SportMutation {

    @MutationMapping
    public Sport createSport(SportInput input) {
        return CreateSport.execute(input);
    }

    @MutationMapping
    public Sport updateSport(String id, SportInput input) {
        final var uuid = UUID.fromString(id);
        return UpdateSport.execute(uuid, input);
    }

}
