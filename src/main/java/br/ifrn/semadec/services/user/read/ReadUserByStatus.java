package br.ifrn.semadec.services.user.read;

import org.springframework.stereotype.Service;

import br.ifrn.semadec.entities.user.User;
import br.ifrn.semadec.entities.user.UserStatus;
import br.ifrn.semadec.repositories.UserRepository;

@Service
public class ReadUserByStatus {

    private UserRepository userRepository;

    public ReadUserByStatus(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> execute(final String status) {
        final var userStatus = UserStatus.valueOf(status);
        return userRepository.findByStatus(userStatus);
    }

}
