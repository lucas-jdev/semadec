package br.ifrn.semadec.resolver;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.context.annotation.Import;
import org.springframework.graphql.test.tester.GraphQlTester;

import br.ifrn.semadec.dtos.user.user_simple.output.UserOutput;
import br.ifrn.semadec.repositories.UserRepositoryInMemory;
import br.ifrn.semadec.repositories.UserProviderRepositoryInMemory;
import br.ifrn.semadec.resolvers.user.query.UserQuery;
import br.ifrn.semadec.services.user.login.LoginUser;
import br.ifrn.semadec.services.user.read.*;

@GraphQlTest(UserQuery.class)
@Import({
        ReadAllUsers.class,
        ReadUserByMatriculation.class,
        ReadUserByAcademicEmail.class,
        ReadUserByPersonalEmail.class,
        ReadUserByUsername.class,
        ReadUserByCpf.class,
        ReadUserByEmail.class,
        ReadUserById.class,
        ReadUsersByFullName.class,
        ReadUsersByCpf.class,
        ReadUsersByEmail.class,
        LoginUser.class,
        UserRepositoryInMemory.class,
        UserProviderRepositoryInMemory.class })
class TestUserQuery {

    @Autowired
    private GraphQlTester tester;

    @Test
    void testReadAllUsers() {
        String document = """
                query {
                    users {
                        id
                        username
                        fullName
                        cpf
                        academicEmail
                        personalEmail
                        matriculation
                    }
                }
                    """;

        tester.document(document)
                .execute()
                .path("users")
                .entityList(UserOutput.class)
                .hasSize(0);
    }
}
