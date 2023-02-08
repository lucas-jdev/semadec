package br.ifrn.semadec.services.user.read;

import java.util.Collection;

import org.springframework.stereotype.Service;

import br.ifrn.semadec.entities.user.User;
import br.ifrn.semadec.repositories.UserRepository;

@Service
public class ReadUsersByEmail {

    private UserRepository userRepository;

    public ReadUsersByEmail(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Collection<User> execute(final String email) {
        return userRepository.findAllByEmail(email);
    }

}
