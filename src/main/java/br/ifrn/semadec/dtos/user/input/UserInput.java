package br.ifrn.semadec.dtos.user.input;

import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import br.ifrn.semadec.entities.user.Gender;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
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

    @Embedded
    private SocialNetworkInput socialNetworks;

    @NotBlank(message = "The password is required")
    private String password;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String birthDate;
    private byte[] photo;
    private String biography;

}
