package br.ifrn.semadec.resolvers.user.mutation;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import br.ifrn.semadec.dtos.oauth.user.UserOauthInput;
import br.ifrn.semadec.dtos.user.user_simple.input.UserInputUpdate;
import br.ifrn.semadec.dtos.user.user_simple.output.UserOutput;
import br.ifrn.semadec.entities.user.User;
import br.ifrn.semadec.services.user.create.CreateUser;
import br.ifrn.semadec.services.user.update.UpdateUser;
import br.ifrn.semadec.services.user_provider.create.CreateUserProvider;
import br.ifrn.semadec.utils.converter.ConvertEntityToDTO;

@Controller
public class UserMutation {

    @Autowired
    private CreateUser createUser;

    @Autowired
    private CreateUserProvider createUserProvider;

    @Autowired
    private UpdateUser updateUser;

    @MutationMapping
    public Object createUser(@Argument final UserOauthInput userInput) {
        if (userInput.getUserProviderInput() != null) {
            return createUserProvider.execute(userInput);
        }
        return createUser.execute(userInput.getUserInput());
    }

    @MutationMapping
    public UserOutput updateUser(@Argument final String id, @Argument final UserInputUpdate userInput) {
        User user = updateUser.execute(UUID.fromString(id), userInput);
        return (UserOutput) ConvertEntityToDTO.convert(user, UserOutput.class);
    }

}
