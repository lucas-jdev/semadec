package br.ifrn.semadec.services.user.read;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.entities.user.User;
import br.ifrn.semadec.repositories.UserRepository;

@Service
public class ReadAllUsers {

    @Autowired
    private UserRepository userRepository;

    public List<User> execute() {
        return userRepository.findAll();
    }

}
