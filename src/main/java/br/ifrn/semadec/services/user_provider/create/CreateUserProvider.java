package br.ifrn.semadec.services.user_provider.create;

import org.springframework.stereotype.Service;

import br.ifrn.semadec.dtos.oauth.user.UserOauthInput;
import br.ifrn.semadec.entities.user.User;
import br.ifrn.semadec.entities.user_provider.Provider;
import br.ifrn.semadec.entities.user_provider.UserProvider;
import br.ifrn.semadec.providers.CustomProvider;
import br.ifrn.semadec.repositories.UserProviderRepository;
import br.ifrn.semadec.repositories.UserRepository;

@Service
public class CreateUserProvider {

    private UserRepository userRepository;

    private UserProviderRepository userProviderRepository;

    public CreateUserProvider(
        UserRepository userRepository,
        UserProviderRepository userProviderRepository) {
        this.userRepository = userRepository;
        this.userProviderRepository = userProviderRepository;
    }

    public UserProvider execute(UserOauthInput input) {
        final Provider provider = input.getUserProviderInput().getProvider();

        final CustomProvider userProvider;
        userProvider = CustomProvider.getInstance(provider);

        User createUser = userProvider.createUser(input);
        createUser.active();

        User savedUser = userRepository.save(createUser);

        UserProvider userProviderEntity = _generatedUserProvider(provider, savedUser);

        return userProviderRepository.save(userProviderEntity);
    }

    private UserProvider _generatedUserProvider(final Provider provider, User savedUser) {
        var userProviderEntity = new UserProvider();
        userProviderEntity.setUsername(savedUser.getUsername());
        userProviderEntity.setProvider(provider);
        userProviderEntity.setToken(savedUser.getToken());
        return userProviderEntity;
    }
}
