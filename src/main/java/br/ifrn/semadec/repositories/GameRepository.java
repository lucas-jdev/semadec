package br.ifrn.semadec.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ifrn.semadec.entities.game.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, UUID> {

    // TODO: implementar métodos de busca

}
