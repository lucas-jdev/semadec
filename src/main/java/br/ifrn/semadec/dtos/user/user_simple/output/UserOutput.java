package br.ifrn.semadec.dtos.user.user_simple.output;

import java.io.Serializable;

import br.ifrn.semadec.dtos.user.UserInterface;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserOutput implements Serializable, UserInterface {

    private String id;
    private String username;
    private String fullName;
    private String matriculation;
    private String phone;
    private String cpf;
    private String academicEmail;
    private String personalEmail;
    private String gender;
    private String birthDate;
    private String status;
    private String[] flags;
    private int likes;
    private byte[] avatar;
    private String biography;

}
