package br.ifrn.semadec.dtos.team.input;

import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TeamInput {

    private TeamIdInput teamIdInput;
    private UUID userId;

}
