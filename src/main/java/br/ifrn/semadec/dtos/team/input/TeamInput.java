package br.ifrn.semadec.dtos.team.input;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TeamInput {

    private TeamIdInput teamIdInput;
    private Number scoreInstance;
    private String userId;

}
