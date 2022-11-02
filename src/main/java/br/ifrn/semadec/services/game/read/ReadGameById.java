package br.ifrn.semadec.services.game.read;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.entities.game.Game;
import br.ifrn.semadec.exceptions.not_found.GameNotFoundException;
import br.ifrn.semadec.repositories.GameRepository;

@Service
public class ReadGameById {

    @Autowired
    private static GameRepository gameRepository;

    private ReadGameById() {
        throw new IllegalStateException("Service class");
    }

    public static Game execute(UUID id) {
        return gameRepository.findById(id)
                .orElseThrow(GameNotFoundException::new);
    }

}
