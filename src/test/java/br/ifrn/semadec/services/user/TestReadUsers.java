package br.ifrn.semadec.services.user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import br.ifrn.semadec.entities.user.Gender;
import br.ifrn.semadec.entities.user.User;
import br.ifrn.semadec.repositories.UserRepository;
import br.ifrn.semadec.repositories.UserRepositoryInMemory;
import br.ifrn.semadec.services.user.read.ReadAllUsers;
import br.ifrn.semadec.services.user.read.ReadUsersByCpf;
import br.ifrn.semadec.services.user.read.ReadUsersByEmail;
import br.ifrn.semadec.services.user.read.ReadUsersByFullName;

@TestInstance(Lifecycle.PER_CLASS)
public class TestReadUsers {

    private static final int AMOUNT_OF_USERS = 2;

    private UserRepository userRepository;

    @BeforeEach
    void init() {
        final var user = new User();
        user.setUsername("username");
        user.setFullName("fullName");
        user.setMatriculation("matriculation");
        user.setPhone("phone");
        user.setCpf("cpf");
        user.setAcademicEmail("academicEmail");
        user.setPersonalEmail("personalEmail");
        user.setPassword("password");
        user.setGender(Gender.NOT_BINARY);
        user.active();

        final var otherUser = new User();
        otherUser.setUsername("otherUsername");
        otherUser.setFullName("otherFullName");
        otherUser.setMatriculation("otherMatriculation");
        otherUser.setPhone("otherPhone");
        otherUser.setCpf("otherCpf");
        otherUser.setAcademicEmail("otherAcademicEmail");
        otherUser.setPersonalEmail("otherPersonalEmail");
        otherUser.setPassword("otherPassword");
        otherUser.setGender(Gender.NOT_BINARY);
        otherUser.active();

        this.userRepository = new UserRepositoryInMemory();
        this.userRepository.save(user);
        this.userRepository.save(otherUser);
    }

    @Test
    void testReadAllUsers() {
        final var readAllUsers = new ReadAllUsers(this.userRepository);
        Collection<User> users = readAllUsers.execute();

        assertEquals(AMOUNT_OF_USERS, users.size());
    }

    @Test
    void testReadUsersByCpf() {
        final var readUsersByCpf = new ReadUsersByCpf(this.userRepository);
        Collection<User> users = readUsersByCpf.execute("p");

        assertEquals(AMOUNT_OF_USERS, users.size());
    }

    @Test
    void testReadUsersByFullName() {
        final var readUsersByFullName = new ReadUsersByFullName(this.userRepository);
        Collection<User> users = readUsersByFullName.execute("ame");

        assertEquals(AMOUNT_OF_USERS, users.size());
    }

    @Test
    void testReadUsersByEmail() {
        final var readUsersByEmail = new ReadUsersByEmail(this.userRepository);
        Collection<User> users = readUsersByEmail.execute("mail");

        assertEquals(AMOUNT_OF_USERS, users.size());
    }

}
