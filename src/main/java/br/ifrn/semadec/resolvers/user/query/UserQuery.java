package br.ifrn.semadec.resolvers.user.query;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ReadAllUsers readAllUsers;

    @Autowired
    private ReadUserByMatriculation readUserByMatriculation;

    @Autowired
    private ReadUserByAcademicEmail readUserByAcademicEmail;

    @Autowired
    private ReadUserByPersonalEmail readUserByPersonalEmail;

    @Autowired
    private ReadUserByUsername readUserByUsername;

    @Autowired
    private ReadUserByCpf readUserByCpf;

    @Autowired
    private ReadUserByEmail readUserByEmail;

    @Autowired
    private ReadUserById readUserById;

    @Autowired
    private ReadUsersByFullName readUsersByFullName;

    @Autowired
    private ReadUsersByCpf readUsersByCpf;

    @Autowired
    private ReadUsersByEmail readUsersByEmail;

    @Autowired
    private LoginUser loginUser;

    @QueryMapping
    public void login(final String username, final String password) {
        loginUser.execute(username, password);
    }

    @QueryMapping(name = "user")
    public UserOutput findById(final String id) {
        User user = readUserById.execute(UUID.fromString(id));
        return (UserOutput) ConvertEntityToDTO.convert(user, UserOutput.class);
    }

    @QueryMapping
    public UserOutput findUserByEmail(final String email) {
        User user = readUserByEmail.execute(email);
        return (UserOutput) ConvertEntityToDTO.convert(user, UserOutput.class);
    }

    @QueryMapping
    public UserOutput findUserByCpf(final String cpf) {
        User user = readUserByCpf.execute(cpf);
        return (UserOutput) ConvertEntityToDTO.convert(user, UserOutput.class);
    }

    @QueryMapping
    public UserOutput findUserByAcademicEmail(final String academicEmail) {
        User user = readUserByAcademicEmail.execute(academicEmail);
        return (UserOutput) ConvertEntityToDTO.convert(user, UserOutput.class);
    }

    @QueryMapping
    public UserOutput findUserByPersonalEmail(final String personalEmail) {
        User user = readUserByPersonalEmail.execute(personalEmail);
        return (UserOutput) ConvertEntityToDTO.convert(user, UserOutput.class);
    }

    @QueryMapping
    public UserOutput findUserByMatriculation(final String matriculation) {
        User user = readUserByMatriculation.execute(matriculation);
        return (UserOutput) ConvertEntityToDTO.convert(user, UserOutput.class);
    }

    @QueryMapping
    public UserOutput findUserByUsername(final String username) {
        User user = readUserByUsername.execute(username);
        return (UserOutput) ConvertEntityToDTO.convert(user, UserOutput.class);
    }

    @QueryMapping(name = "users")
    public Collection<UserOutput> findAll() {
        List<User> users = readAllUsers.execute();
        return _convertInOutput(users);
    }

    @QueryMapping
    public Collection<UserOutput> findAllUsersByName(String name) {
        Collection<User> users = readUsersByFullName.execute(name);
        return _convertInOutput(users);
    }

    @QueryMapping
    public Collection<UserOutput> findAllUsersByEmail(String email) {
        Collection<User> users = readUsersByEmail.execute(email);
        return _convertInOutput(users);
    }

    @QueryMapping
    public Collection<UserOutput> findAllUsersByCpf(String cpf) {
        Collection<User> users = readUsersByCpf.execute(cpf);
        return _convertInOutput(users);
    }

    private List<UserOutput> _convertInOutput(Collection<User> users) {
        return users.stream()
                .parallel()
                .map(user -> (UserOutput) ConvertEntityToDTO.convert(user, UserOutput.class))
                .toList();
    }

}
