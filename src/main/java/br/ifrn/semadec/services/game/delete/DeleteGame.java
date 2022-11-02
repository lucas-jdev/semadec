package br.ifrn.semadec.services.game.delete;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.repositories.GameRepository;

@Service
public class DeleteGame {

    @Autowired
    private static GameRepository gameRepository;

    private DeleteGame() {
        throw new IllegalStateException("Service class");
    }

    public static void execute(UUID id) {
        gameRepository.deleteById(id);
    }
}
