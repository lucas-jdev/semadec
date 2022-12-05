package br.ifrn.semadec.services.user.read;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.entities.user.User;
import br.ifrn.semadec.repositories.UserRepository;

@Service
public class ReadUsersByCpf {

    @Autowired
    private UserRepository userRepository;

    public Collection<User> execute(final String cpf) {
        return userRepository.findAllByCpf(cpf);
    }

}
