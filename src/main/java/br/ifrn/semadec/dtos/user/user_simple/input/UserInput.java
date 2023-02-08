package br.ifrn.semadec.dtos.user.user_simple.input;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import br.ifrn.semadec.entities.user.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInput {

    @NotBlank(message = "The username is required")
    private String username;

    @NotBlank(message = "The name is required")
    private String fullName;

    @NotBlank(message = "The matriculation is required")
    private String matriculation;
    private String phone;

    @CPF(message = "The CPF is invalid")
    private String cpf;

    @Email(message = "The academic email is invalid")
    private String academicEmail;

    @Email(message = "The personal email is invalid")
    private String personalEmail;

    private SocialNetworkInput socialNetworks;

    @NotBlank(message = "The password is required")
    private String password;

    private Gender gender;
    private String birthDate;
    private byte[] photo;
    private String biography;

}
