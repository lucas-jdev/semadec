package br.ifrn.semadec.resolvers.user.query;

import java.util.Collection;
import java.util.List;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import br.ifrn.semadec.dtos.user.output.UserOutput;
import br.ifrn.semadec.entities.user.User;
import br.ifrn.semadec.services.user.login.LoginUser;
import br.ifrn.semadec.services.user.read.ReadAllUsers;
import br.ifrn.semadec.services.user.read.ReadUserByAcademicEmail;
import br.ifrn.semadec.services.user.read.ReadUserByCpf;
import br.ifrn.semadec.services.user.read.ReadUserByEmail;
import br.ifrn.semadec.services.user.read.ReadUserById;
import br.ifrn.semadec.services.user.read.ReadUserByMatriculation;
import br.ifrn.semadec.services.user.read.ReadUserByPersonalEmail;
import br.ifrn.semadec.services.user.read.ReadUserByUsername;
import br.ifrn.semadec.services.user.read.ReadUsersByCpf;
import br.ifrn.semadec.services.user.read.ReadUsersByEmail;
import br.ifrn.semadec.services.user.read.ReadUsersByFullName;
import br.ifrn.semadec.utils.converter.ConvertEntityToDTO;

import java.util.UUID;

@Controller
public class UserQuery {

    @QueryMapping
    public void login(final String username, final String password) {
        LoginUser.execute(username, password);
    }

    @QueryMapping(name = "user")
    public UserOutput findById(final String id) {
        User user = ReadUserById.execute(UUID.fromString(id));
        return (UserOutput) ConvertEntityToDTO.convert(user, UserOutput.class);
    }

    @QueryMapping
    public UserOutput findByEmail(final String email) {
        User user = ReadUserByEmail.execute(email);
        return (UserOutput) ConvertEntityToDTO.convert(user, UserOutput.class);
    }

    @QueryMapping
    public UserOutput findByCpf(final String cpf) {
        User user = ReadUserByCpf.execute(cpf);
        return (UserOutput) ConvertEntityToDTO.convert(user, UserOutput.class);
    }

    @QueryMapping
    public UserOutput findByAcademicEmail(final String academicEmail) {
        User user = ReadUserByAcademicEmail.execute(academicEmail);
        return (UserOutput) ConvertEntityToDTO.convert(user, UserOutput.class);
    }

    @QueryMapping
    public UserOutput findByPersonalEmail(final String personalEmail) {
        User user = ReadUserByPersonalEmail.execute(personalEmail);
        return (UserOutput) ConvertEntityToDTO.convert(user, UserOutput.class);
    }

    @QueryMapping
    public UserOutput findByMatriculation(final String matriculation) {
        User user = ReadUserByMatriculation.execute(matriculation);
        return (UserOutput) ConvertEntityToDTO.convert(user, UserOutput.class);
    }

    @QueryMapping
    public UserOutput findByUsername(final String username) {
        User user = ReadUserByUsername.execute(username);
        return (UserOutput) ConvertEntityToDTO.convert(user, UserOutput.class);
    }

    @QueryMapping(name = "users")
    public Collection<UserOutput> findAll() {
        List<User> users = ReadAllUsers.execute();
        return _convertInOutput(users);
    }

    @QueryMapping
    public Collection<UserOutput> findAllByName(String name) {
        Collection<User> users = ReadUsersByFullName.execute(name);
        return _convertInOutput(users);
    }

    @QueryMapping
    public Collection<UserOutput> findAllByEmail(String email) {
        Collection<User> users = ReadUsersByEmail.execute(email);
        return _convertInOutput(users);
    }

    @QueryMapping
    public Collection<UserOutput> findAllByCpf(String cpf) {
        Collection<User> users = ReadUsersByCpf.execute(cpf);
        return _convertInOutput(users);
    }

    private List<UserOutput> _convertInOutput(Collection<User> users) {
        return users.stream()
                .parallel()
                .map(user -> (UserOutput) ConvertEntityToDTO.convert(user, UserOutput.class))
                .toList();
    }

}
