package br.ifrn.semadec.services.user;

import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import br.ifrn.semadec.entities.user.Gender;
import br.ifrn.semadec.entities.user.User;
import br.ifrn.semadec.entities.user.UserStatus;
import br.ifrn.semadec.exceptions.not_found.UserNotFoundException;
import br.ifrn.semadec.repositories.UserRepository;
import br.ifrn.semadec.repositories.UserRepositoryInMemory;
import br.ifrn.semadec.services.user.delete.DeleteUser;

@TestInstance(Lifecycle.PER_CLASS)
class TestDeleteUser {

    private UserRepository userRepository;
    private User userSavedInMemory;

    @BeforeEach
    void init() {
        User user = new User();
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

        User otherUser = new User();
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
    void deleteUser() {
        userSavedInMemory = userRepository.findByUsername("username");

        DeleteUser deleteUser = new DeleteUser(userRepository);
        deleteUser.execute(userSavedInMemory.getId());

        assertEquals(UserStatus.INACTIVE, userSavedInMemory.getStatus());
    }

    @Test
    void deleteUserWithInvalidId() {
        DeleteUser deleteUser = new DeleteUser(userRepository);

        assertThrows(
                UserNotFoundException.class,
                () -> deleteUser.execute(null));
    }

    @Test
    void deleteUserWithValidIdButUserNotFound() {
        userSavedInMemory = userRepository.findByUsername("username");

        DeleteUser deleteUser = new DeleteUser(userRepository);
        deleteUser.execute(userSavedInMemory.getId());

        assertThrows(
                UserNotFoundException.class,
                () -> userRepository.findByUsername("username"));
    }

    @Test
    void deleteUserWithValidIdButUserIsInactive() {
        final User user = userRepository.findByUsername("username");
        user.inactive();

        DeleteUser deleteUser = new DeleteUser(userRepository);
        deleteUser.execute(user.getId());

        assertThrows(
                UserNotFoundException.class,
                () -> userRepository.findByUsername("username"));
    }

}
