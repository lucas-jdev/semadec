package br.ifrn.semadec.repositories;

import java.util.Collection;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ifrn.semadec.entities.user.User;
import br.ifrn.semadec.entities.user.UserStatus;

public interface UserRepository extends JpaRepository<User, UUID> {

    @Query("""
            SELECT
                u
            FROM
                User u
            WHERE
                u.status = 'ACTIVE'
            AND
                lower(u.academicEmail) = ?1
                or lower(u.personalEmail) = ?1
                """)
    User findByEmail(String email);

    @Query("""
            SELECT
                u
            FROM
                User u
            WHERE
                u.status = 'ACTIVE'
            AND
                lower(u.username) = ?1
                """)
    User findByUsername(String username);

    @Query("""
            SELECT
                u
            FROM
                User u
            WHERE
                u.status = 'ACTIVE'
            AND
                u.cpf = ?1
                """)
    User findByCpf(String cpf);

    @Query("""
            SELECT
                u
            FROM
                User u
            WHERE
                u.status = 'ACTIVE'
            AND
                lower(u.fullName) LIKE %?1%
                """)
    Collection<User> findByFullName(String fullName);

    @Query("""
            SELECT
                u
            FROM
                User u
            WHERE
                u.status = 'ACTIVE'
            AND
                lower(u.academicEmail) LIKE %?1%
                or lower(u.personalEmail) LIKE %?1%
                """)
    Collection<User> findAllByEmail(String email);

    @Query("""
            SELECT
                u
            FROM
                User u
            WHERE
                u.status = 'ACTIVE'
            AND
                lower(u.username) LIKE %?1%
                """)
    Collection<User> findAllByUsername(String username);

    @Query("""
            SELECT
                u
            FROM
                User u
            WHERE
                u.status = 'ACTIVE'
            AND
                u.cpf LIKE %?1%
                """)
    Collection<User> findAllByCpf(String cpf);

    @Deprecated
    @Query("""
            SELECT
                u
            FROM
                User u
            WHERE
                u.status = 'ACTIVE'
            AND
                lower(u.username) = ?1
                    """)
    User findByUsernameAndPassword(String username);

    @Query("""
            SELECT
                u
            FROM
                User u
            WHERE
                u.status = 'ACTIVE'
            AND
                lower(u.academicEmail) = ?1
                """)
    User findByAcademicEmail(String academicEmail);

    @Query("""
            SELECT
                u
            FROM
                User u
            WHERE
                u.status = 'ACTIVE'
            AND
                lower(u.personalEmail) = ?1
                """)
    User findByPersonalEmail(String personalEmail);

    @Query("""
            SELECT
                u
            FROM
                User u
            WHERE
                u.status = 'ACTIVE'
            AND
                u.matriculation = ?1
            """)
    User findByMatriculation(String matriculation);

    @Query("""
            SELECT
                u
            FROM
                User u
            WHERE
                u.status = ?1
                """)
    Collection<User> findByStatus(UserStatus status);
}
