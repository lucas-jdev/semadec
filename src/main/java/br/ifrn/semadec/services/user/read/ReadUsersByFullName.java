package br.ifrn.semadec.services.user.read;

import java.util.Collection;

import org.springframework.stereotype.Service;

import br.ifrn.semadec.entities.user.User;
import br.ifrn.semadec.repositories.UserRepository;

@Service
public class ReadUsersByFullName {

    private UserRepository userRepository;

    public ReadUsersByFullName(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Collection<User> execute(final String fullName) {
        return userRepository.findByFullName(fullName);
    }

}
