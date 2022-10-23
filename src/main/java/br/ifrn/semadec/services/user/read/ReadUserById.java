package br.ifrn.semadec.services.user.read;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.entities.user.User;
import br.ifrn.semadec.exceptions.not_found.UserNotFoundException;
import br.ifrn.semadec.repositories.UserRepository;

import java.util.UUID;

@Service
public class ReadUserById {

    @Autowired
    private static UserRepository userRepository;

    protected ReadUserById() {
        throw new IllegalStateException("Service class");
    }

    public static User execute(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
    }
}
