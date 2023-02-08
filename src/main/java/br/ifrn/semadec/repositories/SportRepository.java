package br.ifrn.semadec.repositories;

import java.util.UUID;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ifrn.semadec.entities.sport.CategoryGender;
import br.ifrn.semadec.entities.sport.Sport;

public interface SportRepository extends JpaRepository<Sport, UUID> {

    @Query("""
            SELECT
                s
            FROM
                Sport s
            WHERE
                s.categoryGender LIKE ?1
            """)
    Collection<Sport> findByCategoryGender(CategoryGender categoryGender);

    @Query("""
            SELECT
                s
            FROM
                Sport s
            WHERE
                lower(s.name) LIKE ?1%
            """)
    Collection<Sport> findByName(String name);

    @Query("""
            SELECT
                s
            FROM
                Sport s
            WHERE
                lower(s.categorySport) LIKE ?1%
            """)
    Collection<Sport> findByCategory(String category);

}
