package br.ifrn.semadec.repositories;

import java.util.UUID;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.ifrn.semadec.entities.flag.Flag;

@Repository
public interface FlagRepository extends JpaRepository<Flag, UUID> {

    @Query("""
            SELECT
                f
            FROM
                Flag f
            WHERE
                lower(f.name) = ?1
            """)
    Flag findByNameEquals(String name);

    @Query("""
            SELECT
                f
            FROM
                Flag f
            WHERE
                lower(f.name) LIKE ?1%
            """)
    Collection<Flag> findByName(String name);

}
