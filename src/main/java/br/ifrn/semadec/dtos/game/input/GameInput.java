package br.ifrn.semadec.dtos.game.input;

import java.util.List;

import br.ifrn.semadec.dtos.team.input.TeamIdInput;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GameInput {

    private String date;
    private String sportId;
    private List<TeamIdInput> teamsId;
    private List<Number> scores;

}
