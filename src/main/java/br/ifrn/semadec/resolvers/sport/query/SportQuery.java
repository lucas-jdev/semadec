package br.ifrn.semadec.resolvers.sport.query;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
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

    @Autowired
    private ReadAllSports readAllSports;

    @Autowired
    private ReadSportById readSportById;

    @Autowired
    private ReadSportsByCategory readSportsByCategory;

    @Autowired
    private ReadSportsByName readSportsByName;

    @Autowired
    private ReadSportsByCategoryGender readSportsByCategoryGender;

    @QueryMapping(name = "sport")
    public Sport findById(@Argument String id) {
        final var uuid = UUID.fromString(id);
        return readSportById.execute(uuid);
    }

    @QueryMapping(name = "sports")
    public Iterable<Sport> findAll() {
        return readAllSports.execute();
    }

    @QueryMapping
    public Iterable<Sport> findSportsByCategory(@Argument String category) {
        return readSportsByCategory.execute(category);
    }

    @QueryMapping
    public Iterable<Sport> findSportsByName(@Argument String name) {
        return readSportsByName.execute(name);
    }

    @QueryMapping
    public Iterable<Sport> findSportsByCategoryGender(@Argument String categoryGender) {
        return readSportsByCategoryGender.execute(categoryGender);
    }

}
