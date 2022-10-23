package br.ifrn.semadec.services.user.read;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ifrn.semadec.entities.user.User;
import br.ifrn.semadec.repositories.UserRepository;

@Service
public class ReadAllUsers {

    private static UserRepository userRepository;

    private ReadAllUsers() {
        throw new IllegalStateException("Service class");
    }

    public static List<User> execute() {
        return userRepository.findAll();
    }

}
