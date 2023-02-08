package br.ifrn.semadec.dtos.user.user_simple.input;

import javax.persistence.Embedded;

import br.ifrn.semadec.entities.user.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInputUpdate {

    private String username;
    private String fullName;
    private String matriculation;
    private String phone;
    private String cpf;
    private String academicEmail;
    private String personalEmail;
    private String password;
    private Gender gender;
    private String birthDate;
    private byte[] photo;
    private String biography;

    @Embedded
    private SocialNetworkInput socialNetworks;

}