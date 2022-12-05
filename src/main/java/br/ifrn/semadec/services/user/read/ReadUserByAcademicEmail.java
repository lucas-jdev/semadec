package br.ifrn.semadec.services.user.read;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.entities.user.User;
import br.ifrn.semadec.repositories.UserRepository;

@Service
public class ReadUserByAcademicEmail {

    @Autowired
    private UserRepository userRepository;

    public User execute(final String academicEmail) {
        return userRepository.findByAcademicEmail(academicEmail);
    }

}
