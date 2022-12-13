package br.ifrn.semadec.resolvers.game.query;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import br.ifrn.semadec.entities.game.Game;
import br.ifrn.semadec.services.game.read.ReadAllGames;
import br.ifrn.semadec.services.game.read.ReadGameById;

@Controller
public class GameQuery {

    @Autowired
    private ReadGameById readGameById;

    @Autowired
    private ReadAllGames readAllGames;

    @QueryMapping(name = "game")
    public Game findById(@Argument String id) {
        final var uuid = UUID.fromString(id);
        return readGameById.execute(uuid);
    }

    @QueryMapping(name = "games")
    public Iterable<Game> findAll() {
        return readAllGames.execute();
    }

}
