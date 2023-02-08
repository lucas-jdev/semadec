package br.ifrn.semadec.dtos.user.user_provider.output;

import br.ifrn.semadec.dtos.user.UserInterface;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserProviderOutput implements UserInterface {

    private String id;
    private String username;
    private String token;
    private String provider;
}
