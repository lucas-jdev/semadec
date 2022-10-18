package br.ifrn.semadec.services.user.create;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.dtos.user.input.UserInput;
import br.ifrn.semadec.dtos.user.output.UserOutput;
import br.ifrn.semadec.entities.user.User;
import br.ifrn.semadec.repositories.UserRepository;

@Service
public class CreateUser {

    private CreateUser() {
        throw new IllegalStateException("Service class");
    }

    @Autowired
    private static UserRepository userRepository;

    public static UserOutput execute(final UserInput input) {
        final var user = _createUserWithDTO(input);

        final var userSaved = userRepository.save(user);

        UserOutput output = _createOutputWithUserSaved(userSaved);

        return output;
    }

    private static UserOutput _createOutputWithUserSaved(final User userSaved) {
        return UserOutput.builder()
                .username(userSaved.getUsername())
                .fullName(userSaved.getFullName())
                .matriculation(userSaved.getMatriculation())
                .phone(userSaved.getPhone())
                .cpf(userSaved.getCpf())
                .academicEmail(userSaved.getAcademicEmail())
                .build();
    }

    private static User _createUserWithDTO(final UserInput input) {
        return User.builder()
                .academicEmail(input.getAcademicEmail())
                .personalEmail(input.getPersonalEmail())
                .username(input.getUsername())
                .password(input.getPassword())
                .fullName(input.getFullName())
                .cpf(input.getCpf())
                .build();
    }

}
