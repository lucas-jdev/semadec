package br.ifrn.semadec.services.user.read;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.entities.user.User;
import br.ifrn.semadec.repositories.UserRepository;

@Service
public class ReadUsersByEmail {

    @Autowired
    private static UserRepository userRepository;

    private ReadUsersByEmail() {
        throw new IllegalStateException("Service class");
    }

    public static Collection<User> execute(final String email) {
        return userRepository.findAllByEmail(email);
    }

}
