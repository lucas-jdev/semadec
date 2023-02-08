package br.ifrn.semadec.providers.oauth;

import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import br.ifrn.semadec.dtos.oauth.user.UserOauthInput;
import br.ifrn.semadec.dtos.user.user_provider.input.UserProviderInput;
import br.ifrn.semadec.entities.user.User;
import br.ifrn.semadec.providers.CustomProvider;
import lombok.Data;

@Component
@Data
public class Suap implements CustomProvider {

    private String matriculation;
    private String campus;
    private String cpf;
    private String token;
    private String academicEmail;
    private String personalEmail;
    private String firstName;
    private String lastName;

    private void _setAllAttributes(UserProviderInput userProviderInput) {
        this.setMatriculation(userProviderInput.getMatriculation());
        this.setCampus(userProviderInput.getCampus());
        this.setCpf(userProviderInput.getCpf());
        this.setToken(userProviderInput.getToken());
        this.setAcademicEmail(userProviderInput.getAcademicEmail());
        this.setPersonalEmail(userProviderInput.getPersonalEmail());
        this.setFirstName(userProviderInput.getFirstName());
        this.setLastName(userProviderInput.getLastName());
    }

    @Override
    public User createUser(UserOauthInput userOauthInput) {
        UserProviderInput userProviderInput;
        userProviderInput = userOauthInput.getUserProviderInput();

        _setAllAttributes(userProviderInput);

        User user = _setUserFields();

        return user;
    }

    private User _setUserFields() {
        User user = new User();
        user.setUsername(_generateUniqueUsername());
        user.setAcademicEmail(this.getAcademicEmail());
        user.setPersonalEmail(this.getPersonalEmail());
        user.setCpf(this.getCpf());
        user.setMatriculation(this.getMatriculation());
        user.setPassword(_generateOneTimeTemporaryPassword());
        user.setToken(this.getToken());
        return user;
    }

    private String _generateOneTimeTemporaryPassword() {
        return this.getMatriculation() + this.getCpf();
    }

    private String _generateUniqueUsername() {
        String capitalizeFirstName = StringUtils.capitalize(this.getFirstName());
        String capitalizeLastName = StringUtils.capitalize(this.getLastName());
        var id = UUID.randomUUID();
        return capitalizeFirstName
                + capitalizeLastName
                + id.getLeastSignificantBits();
    }

}
