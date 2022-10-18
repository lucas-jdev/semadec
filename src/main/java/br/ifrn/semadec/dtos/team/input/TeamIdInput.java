package br.ifrn.semadec.dtos.team.input;

import java.util.UUID;

import lombok.Data;

@Data
public class TeamIdInput {

    private UUID sportId;
    private UUID courseId;

}
