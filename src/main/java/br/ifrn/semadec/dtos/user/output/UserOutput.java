package br.ifrn.semadec.dtos.user.output;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserOutput {

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
