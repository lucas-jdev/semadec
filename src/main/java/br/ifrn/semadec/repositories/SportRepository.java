package br.ifrn.semadec.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.ifrn.semadec.entities.sport.CategoryGender;
import br.ifrn.semadec.entities.sport.Sport;

@Repository
public interface SportRepository extends JpaRepository<Sport, UUID> {

    @Query("""
            SELECT
                s
            FROM
                Sport s
            WHERE
                s.categoryGender = ?1
            """)
    Sport findByCategoryGender(CategoryGender categoryGender);

    @Query("""
            SELECT
                s
            FROM
                Sport s
            WHERE
                lower(s.name) LIKE ?1%
            """)
    Iterable<Sport> findByName(String name);

    @Query("""
            SELECT
                s
            FROM
                Sport s
            WHERE
                lower(s.categorySport) LIKE ?1%
            """)
    Iterable<Sport> findByCategory(String category);

}
