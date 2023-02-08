package br.ifrn.semadec.providers;

import br.ifrn.semadec.providers.oauth.Google;
import br.ifrn.semadec.providers.oauth.Suap;
import br.ifrn.semadec.dtos.oauth.user.UserOauthInput;
import br.ifrn.semadec.entities.user.User;
import br.ifrn.semadec.entities.user_provider.Provider;

public interface CustomProvider {

    static CustomProvider getInstance(Provider provider) {
        return switch (provider) {
            case GOOGLE -> new Google();
            case SUAP -> new Suap();
            default -> throw new IllegalStateException("Unexpected " + provider);
        };
    }

    User createUser(UserOauthInput userOauthInput);

}
