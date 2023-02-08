package br.ifrn.semadec.services.user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import br.ifrn.semadec.dtos.user.user_simple.input.UserInput;
import br.ifrn.semadec.entities.user.Gender;
import br.ifrn.semadec.entities.user.User;
import br.ifrn.semadec.repositories.UserRepository;
import br.ifrn.semadec.repositories.UserRepositoryInMemory;
import br.ifrn.semadec.services.jwt.GeneratorToken;
import br.ifrn.semadec.services.user.create.CreateUser;

@TestInstance(Lifecycle.PER_CLASS)
class TestCreateUser {

    private final String USERNAME_EXPECTED = "username";

    private UserRepository userRepository;
    private GeneratorToken generateToken;
    private UserInput userInputInMemory;

    @BeforeEach
    void init() {
        this.userRepository = new UserRepositoryInMemory();
        this.generateToken = new GeneratorToken();

        userInputInMemory = new UserInput();
        userInputInMemory.setUsername("username");
        userInputInMemory.setFullName("fullName");
        userInputInMemory.setMatriculation("matriculation");
        userInputInMemory.setPhone("phone");
        userInputInMemory.setCpf("cpf");
        userInputInMemory.setAcademicEmail("academicEmail");
        userInputInMemory.setPersonalEmail("personalEmail");
        userInputInMemory.setPassword("password");
        userInputInMemory.setGender(Gender.MALE);
    }

    @Test
    void createUser() {
        CreateUser createUser = new CreateUser(userRepository, generateToken);
        createUser.execute(userInputInMemory);

        User user = userRepository.findByUsername("username");
        assertEquals(user.getUsername(), USERNAME_EXPECTED);
    }

}
