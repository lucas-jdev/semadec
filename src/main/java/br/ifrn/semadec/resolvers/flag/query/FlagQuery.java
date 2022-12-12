package br.ifrn.semadec.resolvers.flag.query;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import br.ifrn.semadec.entities.flag.Flag;
import br.ifrn.semadec.services.flag.read.ReadAllFlags;
import br.ifrn.semadec.services.flag.read.ReadFlagById;
import br.ifrn.semadec.services.flag.read.ReadFlagsByName;

@Controller
public class FlagQuery {

    @Autowired
    private ReadAllFlags readAllFlags;

    @Autowired
    private ReadFlagById readFlagById;

    @Autowired
    private ReadFlagsByName readFlagsByName;

    @QueryMapping(name = "flag")
    public Flag findById(String id) {
        final var uuid = UUID.fromString(id);
        return readFlagById.execute(uuid);
    }

    @QueryMapping(name = "flags")
    public Iterable<Flag> findAll() {
        return readAllFlags.execute();
    }

    @QueryMapping
    public Iterable<Flag> findFlagByName(String name) {
        return readFlagsByName.execute(name);
    }

}
