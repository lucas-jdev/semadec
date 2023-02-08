package br.ifrn.semadec.services.user.read;

import org.springframework.stereotype.Service;

import br.ifrn.semadec.entities.user.User;
import br.ifrn.semadec.repositories.UserRepository;

@Service
public class ReadUserByCpf {

    private UserRepository userRepository;

    public ReadUserByCpf(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(final String cpf) {
        return userRepository.findByCpf(cpf);
    }

}
