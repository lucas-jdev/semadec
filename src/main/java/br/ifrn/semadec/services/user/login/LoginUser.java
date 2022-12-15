package br.ifrn.semadec.services.user.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.entities.user.User;
import br.ifrn.semadec.exceptions.not_found.UserNotFoundException;
import br.ifrn.semadec.repositories.UserRepository;
import br.ifrn.semadec.utils.encrypt.Cryptographer;

@Service
public class LoginUser {

    @Autowired
    private UserRepository userRepository;

    public void execute(final String username, final String password) {
        final var user = username.toLowerCase().trim();
        final var pass = Cryptographer.encrypt(password);
        final User userFound;
        userFound = userRepository.findByUsernameAndPassword(user, pass);
        _validateUser(userFound);
    }

    private void _validateUser(final User userFound) {
        boolean userNotFound = userFound == null;
        if (userNotFound) {
            throw new UserNotFoundException();
        }
    }

}
