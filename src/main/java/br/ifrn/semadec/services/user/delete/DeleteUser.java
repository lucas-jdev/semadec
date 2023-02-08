package br.ifrn.semadec.services.user.delete;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.ifrn.semadec.entities.user.User;
import br.ifrn.semadec.exceptions.not_found.UserNotFoundException;
import br.ifrn.semadec.repositories.UserRepository;

@Service
public class DeleteUser {

    private UserRepository userRepository;

    public DeleteUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execute(final UUID id) {
        Optional<User> findById = userRepository.findById(id);
        throwExceptionIfUserNotFound(findById);
        findById.ifPresent(User::inactive);
        findById.ifPresent(userRepository::save);
    }

    private void throwExceptionIfUserNotFound(Optional<User> findById) {
        if (findById.isEmpty()) {
            throw new UserNotFoundException();
        }
    }
}
