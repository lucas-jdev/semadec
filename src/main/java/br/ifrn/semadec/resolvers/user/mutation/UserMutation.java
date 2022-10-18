package br.ifrn.semadec.resolvers.user.mutation;

import org.springframework.stereotype.Controller;

import br.ifrn.semadec.dtos.user.input.UserInput;
import br.ifrn.semadec.dtos.user.output.UserOutput;
import br.ifrn.semadec.services.user.create.CreateUser;

@Controller
public class UserMutation {

    public UserOutput save(final UserInput input) {
        return CreateUser.execute(input);
    }
}
