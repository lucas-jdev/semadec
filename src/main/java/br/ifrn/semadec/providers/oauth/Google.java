package br.ifrn.semadec.providers.oauth;

import org.springframework.stereotype.Component;

import br.ifrn.semadec.dtos.oauth.user.UserOauthInput;
import br.ifrn.semadec.entities.user.User;
import br.ifrn.semadec.providers.CustomProvider;
import lombok.Data;

@Component
@Data
public class Google implements CustomProvider {

    private String username;
    private String token;

    public void _setAllAttibutes(UserOauthInput userOauthInput) {
        this.setUsername(userOauthInput.getUserProviderInput().getUsername());
        this.setToken(userOauthInput.getUserProviderInput().getToken());
    }

    private User _setUserFields() {
        User user = new User();
        user.setUsername(this.getUsername());
        user.setToken(this.getToken());

        return user;
    }

    @Override
    public User createUser(UserOauthInput userOauthInput) {
        this.setUsername(userOauthInput.getUserProviderInput().getUsername());
        this.setToken(userOauthInput.getUserProviderInput().getToken());

        User user = _setUserFields();

        return user;
    }

}
