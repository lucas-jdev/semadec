package br.ifrn.semadec.services.user.update;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.dtos.user.input.UserInput;
import br.ifrn.semadec.entities.user.User;
import br.ifrn.semadec.exceptions.not_found.UserNotFoundException;
import br.ifrn.semadec.repositories.UserRepository;

@Service
public class UpdateUser {

    @Autowired
    private UserRepository userRepository;

    public User execute(final UUID userId, final UserInput input) {
        return userRepository.findById(userId).map(user -> {
            user.setUsername(input.getUsername());
            user.setFullName(input.getFullName());
            user.setCpf(input.getCpf());
            user.setAcademicEmail(input.getAcademicEmail());
            user.setPersonalEmail(input.getPersonalEmail());
            user.setPhone(input.getPhone());
            user.setMatriculation(input.getMatriculation());
            return userRepository.save(user);
        }).orElseThrow(UserNotFoundException::new);
    }

}
