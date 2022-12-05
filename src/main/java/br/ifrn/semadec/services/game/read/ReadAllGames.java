package br.ifrn.semadec.services.game.read;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.entities.game.Game;
import br.ifrn.semadec.repositories.GameRepository;

@Service
public class ReadAllGames {

    @Autowired
    private GameRepository gameRepository;

    public Collection<Game> execute() {
        return gameRepository.findAll();
    }
}
