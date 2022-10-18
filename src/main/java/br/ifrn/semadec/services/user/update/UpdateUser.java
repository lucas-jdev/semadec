package br.ifrn.semadec.services.user.update;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.entities.user.User;
import br.ifrn.semadec.repositories.UserRepository;

@Service
public class UpdateUser {

    @Autowired
    private static UserRepository userRepository;

    private UpdateUser() {
        throw new IllegalStateException("Service class");
    }

    public static User execute(final User user) {
        return userRepository.saveAndFlush(user);
    }

}
