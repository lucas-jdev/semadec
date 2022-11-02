package br.ifrn.semadec.resolvers.flag.query;

import java.util.UUID;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import br.ifrn.semadec.entities.flag.Flag;
import br.ifrn.semadec.services.flag.read.ReadAllFlags;
import br.ifrn.semadec.services.flag.read.ReadFlagById;
import br.ifrn.semadec.services.flag.read.ReadFlagsByName;

@Controller
public class FlagQuery {

    @QueryMapping
    public Flag findById(String id) {
        final var uuid = UUID.fromString(id);
        return ReadFlagById.execute(uuid);
    }

    @QueryMapping
    public Iterable<Flag> findAll() {
        return ReadAllFlags.execute();
    }

    @QueryMapping
    public Iterable<Flag> findByName(String name) {
        return ReadFlagsByName.execute(name);
    }

}
