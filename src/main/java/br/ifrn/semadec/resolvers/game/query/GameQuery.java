package br.ifrn.semadec.resolvers.game.query;

import java.util.UUID;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import br.ifrn.semadec.entities.game.Game;
import br.ifrn.semadec.services.game.read.ReadAllGames;
import br.ifrn.semadec.services.game.read.ReadGameById;

@Controller
public class GameQuery {

    @QueryMapping
    public Game findById(String id) {
        final var uuid = UUID.fromString(id);
        return ReadGameById.execute(uuid);
    }

    @QueryMapping
    public Iterable<Game> findAll() {
        return ReadAllGames.execute();
    }

}
