package br.ifrn.semadec.dtos.user.output;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserOutput {

    private String username;
    private String fullName;
    private String matriculation;
    private String phone;
    private String cpf;
    private String academicEmail;

}