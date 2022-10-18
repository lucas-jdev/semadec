package br.ifrn.semadec.entities.team;

import java.util.Set;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.ifrn.semadec.entities.score.Score;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name = "teams")
public class Team {

    @EmbeddedId
    private TeamId id;

    @OneToOne
    private Score scoreInstance;

    @OneToMany
    private Set<Player> players;

}
