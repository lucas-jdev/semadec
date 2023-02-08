package br.ifrn.semadec.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifrn.semadec.entities.game.Game;

public interface GameRepository extends JpaRepository<Game, UUID> {

    // TODO: implementar métodos de busca

}
