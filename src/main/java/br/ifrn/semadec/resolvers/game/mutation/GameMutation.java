package br.ifrn.semadec.resolvers.game.mutation;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import br.ifrn.semadec.dtos.game.input.GameInput;
import br.ifrn.semadec.entities.game.Game;
import br.ifrn.semadec.services.game.create.CreateGame;
import br.ifrn.semadec.services.game.update.UpdateGame;

@Controller
public class GameMutation {

    @Autowired
    private CreateGame createGame;

    @Autowired
    private UpdateGame updateGame;

    @MutationMapping
    public Game createGame(GameInput input) {
        return createGame.execute(input);
    }

    @MutationMapping
    public Game updateGame(String id, GameInput input) {
        final var uuid = UUID.fromString(id);
        return updateGame.execute(uuid, input);
    }

}
