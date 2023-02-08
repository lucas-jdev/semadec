package br.ifrn.semadec.services.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import br.ifrn.semadec.entities.user.Gender;
import br.ifrn.semadec.entities.user.User;
import br.ifrn.semadec.entities.user.UserStatus;
import br.ifrn.semadec.repositories.UserRepository;
import br.ifrn.semadec.repositories.UserRepositoryInMemory;
import br.ifrn.semadec.services.user.read.ReadUserByAcademicEmail;
import br.ifrn.semadec.services.user.read.ReadUserByCpf;
import br.ifrn.semadec.services.user.read.ReadUserByEmail;
import br.ifrn.semadec.services.user.read.ReadUserById;
import br.ifrn.semadec.services.user.read.ReadUserByMatriculation;
import br.ifrn.semadec.services.user.read.ReadUserByPersonalEmail;
import br.ifrn.semadec.services.user.read.ReadUserByUsername;

@TestInstance(Lifecycle.PER_CLASS)
public class TestReadUser {

    private UserRepository userRepository;
    private User userSavedInMemory;

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
    void findUserByUsername() {
        ReadUserByUsername readUser = new ReadUserByUsername(this.userRepository);
        userSavedInMemory = readUser.execute("username");

        assertEquals("username", userSavedInMemory.getUsername());
    }

    @Test
    void findUserByEmail() {
        ReadUserByEmail readUser = new ReadUserByEmail(this.userRepository);
        userSavedInMemory = readUser.execute("personalEmail");

        assertEquals("academicEmail", userSavedInMemory.getAcademicEmail());
    }

    @Test
    void findUserByCpf() {
        ReadUserByCpf readUser = new ReadUserByCpf(this.userRepository);
        userSavedInMemory = readUser.execute("cpf");

        assertEquals("cpf", userSavedInMemory.getCpf());
    }

    @Test
    void findUserByMatriculation() {
        ReadUserByMatriculation readUser = new ReadUserByMatriculation(this.userRepository);
        userSavedInMemory = readUser.execute("matriculation");

        assertEquals("matriculation", userSavedInMemory.getMatriculation());
    }

    @Test
    void findUserById() {
        userSavedInMemory = this.userRepository.findByUsername("username");

        ReadUserById readUser = new ReadUserById(this.userRepository);
        userSavedInMemory = readUser.execute(userSavedInMemory.getId());

        assertNotNull(userSavedInMemory);
    }

    @Test
    void findUserByAcademicEmail() {
        ReadUserByAcademicEmail readUser = new ReadUserByAcademicEmail(this.userRepository);
        userSavedInMemory = readUser.execute("academicEmail");

        assertEquals("academicEmail", userSavedInMemory.getAcademicEmail());
    }

    @Test
    void findUserByPersonalEmail() {
        ReadUserByPersonalEmail readUser = new ReadUserByPersonalEmail(this.userRepository);
        userSavedInMemory = readUser.execute("personalEmail");

        assertEquals("personalEmail", userSavedInMemory.getPersonalEmail());
    }

    @Test
    void findUserByStatusActive() {
        userSavedInMemory = this.userRepository.findByUsername("username");

        ReadUserById readUser = new ReadUserById(this.userRepository);
        userSavedInMemory = readUser.execute(userSavedInMemory.getId());

        assertEquals(UserStatus.ACTIVE, userSavedInMemory.getStatus());
    }

    @Test
    void findUserByStatusInactive() {
        userSavedInMemory = this.userRepository.findByUsername("username");
        userSavedInMemory.inactive();

        ReadUserById readUser = new ReadUserById(this.userRepository);
        userSavedInMemory = readUser.execute(userSavedInMemory.getId());

        assertEquals(UserStatus.INACTIVE, userSavedInMemory.getStatus());
    }

    @Test
    void findUserByStatusBlocked() {
        userSavedInMemory = this.userRepository.findByUsername("username");
        userSavedInMemory.block();

        ReadUserById readUser = new ReadUserById(this.userRepository);
        userSavedInMemory = readUser.execute(userSavedInMemory.getId());

        assertEquals(UserStatus.BLOCKED, userSavedInMemory.getStatus());
    }

}
