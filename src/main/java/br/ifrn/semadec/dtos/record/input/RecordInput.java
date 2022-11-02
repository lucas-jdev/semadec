package br.ifrn.semadec.dtos.record.input;

import br.ifrn.semadec.dtos.team.input.TeamIdInput;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RecordInput {

    private Number score;
    private String description;
    private String dateTime;
    private String sportId;
    private String courseId;
    private String playerId;
    private TeamIdInput teamId;

}
