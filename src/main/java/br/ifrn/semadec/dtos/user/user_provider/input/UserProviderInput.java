package br.ifrn.semadec.dtos.user.user_provider.input;

import br.ifrn.semadec.entities.user_provider.Provider;
import lombok.Data;

@Data
public class UserProviderInput {

    private String username;
    private String matriculation;
    private String campus;
    private String cpf;
    private String token;
    private String academicEmail;
    private String personalEmail;
    private String firstName;
    private String lastName;
    private Provider provider;

}
