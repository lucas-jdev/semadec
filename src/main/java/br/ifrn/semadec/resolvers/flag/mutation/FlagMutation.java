package br.ifrn.semadec.resolvers.flag.mutation;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import br.ifrn.semadec.entities.flag.Flag;
import br.ifrn.semadec.services.flag.create.CreateFlag;
import br.ifrn.semadec.services.flag.update.UpdateFlag;

@Controller
public class FlagMutation {

    @Autowired
    private CreateFlag createFlag;

    @Autowired
    private UpdateFlag updateFlag;

    @MutationMapping
    public Flag createFlag(String name) {
        return createFlag.execute(name);
    }

    @MutationMapping
    public Flag updateFlag(String id, String name) {
        final var uuid = UUID.fromString(id);
        return updateFlag.execute(uuid, name);
    }

}
