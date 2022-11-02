package br.ifrn.semadec.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ifrn.semadec.entities.team.Player;
import br.ifrn.semadec.entities.user.User;

public interface PlayerRepository extends JpaRepository<Player, User> {

    @Query("""
            SELECT p
            FROM Player p
            JOIN p.user u
            WHERE u.id = :id
                """)
    Player findById(UUID id);

}
