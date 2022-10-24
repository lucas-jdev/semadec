package br.ifrn.semadec.repositories;

import java.util.UUID;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.ifrn.semadec.entities.course.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, UUID> {

    @Query("""
            SELECT
                c
            FROM
                Course c
            WHERE
                lower(c.name) = ?1
            """)
    Course findByNameEquals(String name);

    @Query("""
            SELECT
                c
            FROM
                Course c
            WHERE
                lower(c.name) LIKE ?1%
            """)
    Collection<Course> findByName(String name);

}
