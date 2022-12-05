package br.ifrn.semadec.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ifrn.semadec.entities.team.Player;

public interface PlayerRepository extends JpaRepository<Player, UUID> {

    @Query("""
            SELECT p
            FROM Player p
            JOIN p.user u
            WHERE u.id = :id
                """)
    Optional<Player> findById(UUID id);

}
