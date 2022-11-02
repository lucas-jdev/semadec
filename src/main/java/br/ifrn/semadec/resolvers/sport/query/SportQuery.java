package br.ifrn.semadec.resolvers.sport.query;

import java.util.UUID;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import br.ifrn.semadec.entities.sport.Sport;
import br.ifrn.semadec.services.sport.read.ReadAllSports;
import br.ifrn.semadec.services.sport.read.ReadSportById;
import br.ifrn.semadec.services.sport.read.ReadSportsByCategory;
import br.ifrn.semadec.services.sport.read.ReadSportsByCategoryGender;
import br.ifrn.semadec.services.sport.read.ReadSportsByName;

@Controller
public class SportQuery {

    @QueryMapping(name = "sport")
    public Sport findById(String id) {
        final var uuid = UUID.fromString(id);
        return ReadSportById.execute(uuid);
    }

    @QueryMapping(name = "sports")
    public Iterable<Sport> findAll() {
        return ReadAllSports.execute();
    }

    @QueryMapping
    public Iterable<Sport> findByCategory(String category) {
        return ReadSportsByCategory.execute(category);
    }

    @QueryMapping
    public Iterable<Sport> findByName(String name) {
        return ReadSportsByName.execute(name);
    }

    @QueryMapping
    public Iterable<Sport> findByCategoryGender(String categoryGender) {
        return ReadSportsByCategoryGender.execute(categoryGender);
    }

}
