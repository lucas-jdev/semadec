package br.ifrn.semadec.services.user;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import br.ifrn.semadec.dtos.user.UserInterface;
import br.ifrn.semadec.dtos.user.user_simple.input.UserLoginInput;
import br.ifrn.semadec.entities.user.Gender;
import br.ifrn.semadec.entities.user_provider.Provider;
import br.ifrn.semadec.entities.user.User;
import br.ifrn.semadec.entities.user_provider.UserProvider;
import br.ifrn.semadec.repositories.UserProviderRepository;
import br.ifrn.semadec.repositories.UserRepository;
import br.ifrn.semadec.repositories.UserProviderRepositoryInMemory;
import br.ifrn.semadec.repositories.UserRepositoryInMemory;
import br.ifrn.semadec.services.user.login.LoginUser;
import br.ifrn.semadec.utils.encrypt.Cryptographer;

@TestInstance(Lifecycle.PER_CLASS)
public class TestLoginUser {

    private UserRepository userRepository;
    private UserProviderRepository userProviderRepository;

    @BeforeAll
    void init() {
        User user = new User();
        user.setUsername("username");
        user.setFullName("fullName");
        user.setMatriculation("matriculation");
        user.setPhone("phone");
        user.setCpf("cpf");
        user.setAcademicEmail("academicEmail");
        user.setPersonalEmail("personalEmail");
        user.setGender(Gender.NOT_BINARY);
        user.setPassword(Cryptographer.encrypt("password"));
        user.active();

        UserProvider userProvider = new UserProvider();
        userProvider.setUsername("John Doe");
        userProvider.setToken("token");
        userProvider.setProvider(Provider.GOOGLE);

        this.userRepository = new UserRepositoryInMemory();
        this.userRepository.save(user);

        this.userProviderRepository = new UserProviderRepositoryInMemory();
        this.userProviderRepository.save(userProvider);
    }

    @Test
    void loginUser() {
        UserLoginInput userLoginInput = new UserLoginInput();
        userLoginInput.setUsername("username");
        userLoginInput.setPassword("password");

        LoginUser loginUser = new LoginUser(userRepository, userProviderRepository);
        UserInterface user = loginUser.execute(userLoginInput);

        assertNotNull(user);
    }

    @Test
    void loginUserWithProvider() {
        UserLoginInput userLoginInput = new UserLoginInput();
        userLoginInput.setUsername("John Doe");
        userLoginInput.setToken("token");
        userLoginInput.setProvider(Provider.GOOGLE);

        LoginUser loginUser = new LoginUser(userRepository, userProviderRepository);
        UserInterface user = loginUser.execute(userLoginInput);

        assertNotNull(user);
    }

}
