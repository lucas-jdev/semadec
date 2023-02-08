package br.ifrn.semadec.dtos.oauth.user;

import br.ifrn.semadec.dtos.user.user_provider.input.UserProviderInput;
import br.ifrn.semadec.dtos.user.user_simple.input.UserInput;
import lombok.Data;

@Data
public class UserOauthInput {

    private UserInput userInput;
    private UserProviderInput userProviderInput;

}
