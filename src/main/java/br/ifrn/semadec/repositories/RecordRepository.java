package br.ifrn.semadec.repositories;

import java.util.Collection;
import java.util.UUID;
import br.ifrn.semadec.entities.record.Record;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends JpaRepository<Record, UUID> {

    @Query("""
            SELECT
                r
            FROM
                Record r
            INNER JOIN
                r.sport s
            ON
                r.sport = s
            WHERE
                s.id = ?1
            """)
    Record findBySportId(UUID sportId);

    @Query("""
            SELECT
                r
            FROM
                Record r
            INNER JOIN
                r.player p
            ON
                r.player = p
            WHERE
                p.id = ?1
            """)
    Record findByPlayerId(UUID playerId);

    @Query("""
            SELECT
                r
            FROM
                Record r
            INNER JOIN
                r.player p
            INNER JOIN
                User u
            ON
                r.player = p
                AND
                p.user = u
            WHERE
                lower(u.username) LIKE ?1%
            """)
    Collection<Record> findByPlayerUsername(String username);

    @Query("""
            SELECT
                r
            FROM
                Record r
            INNER JOIN
                r.player p
            INNER JOIN
                User u
            ON
                r.player = p
                AND
                p.user = u
            WHERE
                lower(u.fullName) LIKE ?1%
            """)
    Collection<Record> findByPlayerFullName(String fullName);

}
