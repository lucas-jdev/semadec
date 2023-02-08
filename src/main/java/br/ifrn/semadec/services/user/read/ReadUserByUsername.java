package br.ifrn.semadec.services.user.read;

import org.springframework.stereotype.Service;

import br.ifrn.semadec.entities.user.User;
import br.ifrn.semadec.repositories.UserRepository;

@Service
public class ReadUserByUsername {

    private UserRepository userRepository;

    public ReadUserByUsername(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(final String username) {
        return userRepository.findByUsername(username);
    }

}
