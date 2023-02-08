package br.ifrn.semadec.dtos.user.user_simple.input;

import javax.validation.constraints.NotBlank;

import br.ifrn.semadec.entities.user_provider.Provider;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginInput {

    @NotBlank(message = "Username is required")
    private String username;
    private String password;
    private String token;
    private Provider provider;

}
