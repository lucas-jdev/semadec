package br.ifrn.semadec.services.user.read;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ifrn.semadec.entities.user.User;
import br.ifrn.semadec.repositories.UserRepository;

@Service
public class ReadAllUsers {

    private UserRepository userRepository;

    public ReadAllUsers(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> execute() {
        return userRepository.findAll();
    }

}
