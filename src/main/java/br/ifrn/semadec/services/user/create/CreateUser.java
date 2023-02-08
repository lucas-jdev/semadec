package br.ifrn.semadec.services.user.create;

import java.util.Collection;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.dtos.user.user_simple.input.UserInput;
import br.ifrn.semadec.dtos.user.user_simple.output.UserOutput;
import br.ifrn.semadec.entities.flag.Flag;
import br.ifrn.semadec.entities.user.User;
import br.ifrn.semadec.repositories.UserRepository;
import br.ifrn.semadec.services.jwt.GeneratorToken;
import br.ifrn.semadec.utils.encrypt.Cryptographer;

@Service
public class CreateUser {

    private UserRepository userRepository;
    private GeneratorToken generatorToken;

    public CreateUser(UserRepository userRepository, GeneratorToken generatorToken) {
        this.userRepository = userRepository;
        this.generatorToken = generatorToken;
    }

    public UserOutput execute(final UserInput input) {
        final var user = _createUserWithDTO(input);
        user.active();

        String tokenGenerated = generatorToken.execute(user);
        user.setToken(tokenGenerated);

        final var userSaved = userRepository.save(user);

        UserOutput output = _createOutputWithUserSaved(userSaved);

        return output;
    }

    private UserOutput _createOutputWithUserSaved(final User userSaved) {
        String date = userSaved.getBirthDate() != null ? userSaved.getBirthDate().toString() : null;
        Collection<Flag> flags = userSaved.getFlags();
        return UserOutput.builder()
                .id(userSaved.getId().toString())
                .username(userSaved.getUsername())
                .fullName(userSaved.getFullName())
                .matriculation(userSaved.getMatriculation())
                .phone(userSaved.getPhone())
                .cpf(userSaved.getCpf())
                .academicEmail(userSaved.getAcademicEmail())
                .personalEmail(userSaved.getPersonalEmail())
                .gender(userSaved.getGender().toString())
                .birthDate(date)
                .status(userSaved.getStatus().toString())
                .flags(_getFlags(flags))
                .build();
    }

    private User _createUserWithDTO(final UserInput input) {
        return User.builder()
                .id(null)
                .gender(input.getGender())
                .academicEmail(input.getAcademicEmail())
                .matriculation(input.getMatriculation())
                .personalEmail(input.getPersonalEmail())
                .username(input.getUsername())
                .password(Cryptographer.encrypt(input.getPassword()))
                .fullName(input.getFullName())
                .cpf(input.getCpf())
                .build();
    }

    private String[] _getFlags(Collection<Flag> flags) {
        if (flags == null || flags.isEmpty()) {
            return Strings.EMPTY_ARRAY;
        }

        return flags.stream()
                .map(flag -> flag.getName())
                .toArray(String[]::new);
    }

}
