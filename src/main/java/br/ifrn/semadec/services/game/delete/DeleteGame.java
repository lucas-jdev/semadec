package br.ifrn.semadec.services.game.delete;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.repositories.GameRepository;

@Service
public class DeleteGame {

    @Autowired
    private GameRepository gameRepository;

    public void execute(UUID id) {
        gameRepository.deleteById(id);
    }
}
