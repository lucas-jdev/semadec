package br.ifrn.semadec.services.user.read;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.entities.user.User;
import br.ifrn.semadec.repositories.UserRepository;

@Service
public class ReadUserByMatriculation {

    @Autowired
    private static UserRepository userRepository;

    private ReadUserByMatriculation() {
        throw new IllegalStateException("Service class");
    }

    public static User execute(final String matriculation) {
        return userRepository.findByMatriculation(matriculation);
    }

}
