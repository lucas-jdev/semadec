package br.ifrn.semadec.services.user.read;

import org.springframework.stereotype.Service;

import br.ifrn.semadec.entities.user.User;
import br.ifrn.semadec.repositories.UserRepository;

@Service
public class ReadUserByMatriculation {

    private UserRepository userRepository;

    public ReadUserByMatriculation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(final String matriculation) {
        return userRepository.findByMatriculation(matriculation);
    }

}
