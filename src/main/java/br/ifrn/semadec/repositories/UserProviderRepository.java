package br.ifrn.semadec.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ifrn.semadec.entities.user_provider.UserProvider;

public interface UserProviderRepository extends JpaRepository<UserProvider, UUID> {

    @Query("""
            SELECT u FROM UserProvider u
            WHERE u.username = :username
            AND u.token = :token
            """)
    UserProvider findByUsernameAndToken(String username, String token);
}
