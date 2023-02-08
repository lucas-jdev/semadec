package br.ifrn.semadec.services.user.read;

import org.springframework.stereotype.Service;

import br.ifrn.semadec.entities.user.User;
import br.ifrn.semadec.repositories.UserRepository;

@Service
public class ReadUserByAcademicEmail {

    private UserRepository userRepository;

    public ReadUserByAcademicEmail(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(final String academicEmail) {
        return userRepository.findByAcademicEmail(academicEmail);
    }

}
