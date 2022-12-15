package br.ifrn.semadec.resolvers.user.mutation;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import br.ifrn.semadec.dtos.user.input.UserInput;
import br.ifrn.semadec.dtos.user.output.UserOutput;
import br.ifrn.semadec.entities.user.User;
import br.ifrn.semadec.services.user.create.CreateUser;
import br.ifrn.semadec.services.user.update.UpdateUser;
import br.ifrn.semadec.utils.converter.ConvertEntityToDTO;

@Controller
public class UserMutation {

    @Autowired
    private CreateUser createUser;

    @Autowired
    private UpdateUser updateUser;

    @MutationMapping(name = "createUser")
    public UserOutput save(@Argument final UserInput input) {
        return createUser.execute(input);
    }

    @MutationMapping(name = "updateUser")
    public UserOutput update(@Argument final String id, @Argument final UserInput input) {
        User user = updateUser.execute(UUID.fromString(id), input);
        return (UserOutput) ConvertEntityToDTO.convert(user, UserOutput.class);
    }

}
