package br.ifrn.semadec.services.user.read;

import java.util.Collection;

import org.springframework.stereotype.Service;

import br.ifrn.semadec.entities.user.User;
import br.ifrn.semadec.repositories.UserRepository;

@Service
public class ReadUsersByCpf {

    private UserRepository userRepository;

    public ReadUsersByCpf(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Collection<User> execute(final String cpf) {
        return userRepository.findAllByCpf(cpf);
    }

}
