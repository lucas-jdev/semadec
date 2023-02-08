package br.ifrn.semadec.services.user.login;

import org.springframework.stereotype.Service;

import br.ifrn.semadec.dtos.user.UserInterface;
import br.ifrn.semadec.dtos.user.user_provider.output.UserProviderOutput;
import br.ifrn.semadec.dtos.user.user_simple.input.UserLoginInput;
import br.ifrn.semadec.dtos.user.user_simple.output.UserOutput;
import br.ifrn.semadec.entities.user.User;
import br.ifrn.semadec.entities.user_provider.UserProvider;
import br.ifrn.semadec.exceptions.not_found.UserNotFoundException;
import br.ifrn.semadec.repositories.UserProviderRepository;
import br.ifrn.semadec.repositories.UserRepository;
import br.ifrn.semadec.utils.encrypt.Cryptographer;

@Service
public class LoginUser {

    private UserRepository userRepository;
    private UserProviderRepository userProviderRepository;

    public LoginUser(UserRepository userRepository, UserProviderRepository userProviderRepository) {
        this.userRepository = userRepository;
        this.userProviderRepository = userProviderRepository;
    }

    public UserInterface execute(UserLoginInput input) {
        final String user = input.getUsername().toLowerCase().trim();
        final String pass = input.getPassword();

        if (_isLoginWithProvider(input)) {
            return _loginWithUsernameAndToken(user, input.getToken());
        }

        return _loginWithUsernameAndPassword(user, pass);

    }

    private boolean _isLoginWithProvider(final UserLoginInput input) {
        boolean hasProvider = input.getProvider() != null;
        boolean hasToken = input.getToken() != null;
        return hasProvider && hasToken;
    }

    private UserInterface _loginWithUsernameAndToken(final String username, final String token) {
        final UserProvider userFound = userProviderRepository.findByUsernameAndToken(username, token);
        _validateUserFound(userFound);

        UserProviderOutput userOutput = new UserProviderOutput();
        userOutput.setUsername(userFound.getUsername());
        userOutput.setToken(token);
        userOutput.setProvider(userFound.getProvider().toString());

        return userOutput;

    }

    private UserInterface _loginWithUsernameAndPassword(final String username, final String pass) {
        final User userFound = userRepository.findByUsername(username);
        _validateUserFound(userFound);

        if (_isPasswordInvalid(pass, userFound.getPassword())) {
            throw new IllegalStateException("Password is not valid");
        }

        UserOutput userOutput = new UserOutput();
        userOutput.setUsername(userFound.getUsername());
        userOutput.setFullName(userFound.getFullName());
        userOutput.setMatriculation(userFound.getMatriculation());
        userOutput.setPhone(userFound.getPhone());
        userOutput.setCpf(userFound.getCpf());
        userOutput.setAcademicEmail(userFound.getAcademicEmail());
        userOutput.setPersonalEmail(userFound.getPersonalEmail());
        userOutput.setGender(userFound.getGender().toString());
        return userOutput;
    }

    private void _validateUserFound(final Object userFound) {
        boolean userNotFound = userFound == null;
        if (userNotFound) {
            throw new UserNotFoundException();
        }
    }

    private boolean _isPasswordInvalid(final String password, final String passwordEncrypted) {
        return !Cryptographer.matches(password, passwordEncrypted);
    }

}
