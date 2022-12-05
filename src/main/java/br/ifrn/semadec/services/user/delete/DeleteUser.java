package br.ifrn.semadec.services.user.delete;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.entities.user.User;
import br.ifrn.semadec.repositories.UserRepository;

@Service
public class DeleteUser {

    @Autowired
    private UserRepository userRepository;

    public void execute(final UUID id) {
        Optional<User> findById = userRepository.findById(id);
        findById.ifPresent(User::inactive);
        findById.ifPresent(userRepository::save);
    }
}
