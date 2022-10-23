package br.ifrn.semadec.resolvers.user.mutation;

import java.util.UUID;

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

    @MutationMapping
    public UserOutput save(final UserInput input) {
        return CreateUser.execute(input);
    }

    @MutationMapping
    public UserOutput update(final String id, final UserInput input) {
        User user = UpdateUser.execute(UUID.fromString(id), input);
        return (UserOutput) ConvertEntityToDTO.convert(user, UserOutput.class);
    }

}
