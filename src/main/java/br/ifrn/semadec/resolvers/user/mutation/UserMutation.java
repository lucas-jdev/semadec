package br.ifrn.semadec.resolvers.user.mutation;

import java.util.UUID;

import org.springframework.stereotype.Controller;

import br.ifrn.semadec.dtos.user.input.UserInput;
import br.ifrn.semadec.dtos.user.output.UserOutput;
import br.ifrn.semadec.entities.user.User;
import br.ifrn.semadec.services.user.create.CreateUser;
import br.ifrn.semadec.services.user.update.UpdateUser;
import br.ifrn.semadec.utils.converter.ConvertEntityToDTO;

@Controller
public class UserMutation {

    public UserOutput save(final UserInput input) {
        return CreateUser.execute(input);
    }

    public UserOutput update(final String id, final UserInput input) {
        User user = UpdateUser.execute(UUID.fromString(id), input);
        return (UserOutput) ConvertEntityToDTO.convert(user, UserOutput.class);
    }

}
