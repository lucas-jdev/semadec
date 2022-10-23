package br.ifrn.semadec.services.user.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.entities.user.User;
import br.ifrn.semadec.exceptions.not_found.UserNotFoundException;
import br.ifrn.semadec.repositories.UserRepository;

@Service
public class LoginUser {

    @Autowired
    private static UserRepository userRepository;

    private LoginUser() {
        throw new IllegalStateException("Service class");
    }

    public static void execute(final String username, final String password) {
        final var user = username.toLowerCase().trim();
        final var pass = password.trim();
        final User userFound;
        userFound = userRepository.findByUsernameAndPassword(user, pass);
        _validateUser(userFound);
    }

    private static void _validateUser(final User userFound) {
        boolean userNotFound = userFound == null;
        if (userNotFound) {
            throw new UserNotFoundException();
        }
    }

}
