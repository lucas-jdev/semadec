package br.ifrn.semadec.services.user.read;

import org.springframework.stereotype.Service;

import br.ifrn.semadec.entities.user.User;
import br.ifrn.semadec.repositories.UserRepository;

@Service
public class ReadUserByPersonalEmail {

    private UserRepository userRepository;

    public ReadUserByPersonalEmail(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(final String personalEmail) {
        return userRepository.findByPersonalEmail(personalEmail);
    }

}
