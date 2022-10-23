package br.ifrn.semadec.entities.game;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.ifrn.semadec.entities.score.Score;
import br.ifrn.semadec.entities.sport.Sport;
import br.ifrn.semadec.entities.team.Team;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(columnDefinition = "timestamp")
    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    private StatusGame status;

    @OneToOne
    private Sport sport;

    @OneToMany
    private List<Team> teams;

    @OneToMany
    private List<Score> scores;

    public void finishGame() {
        this.status = StatusGame.FINISHED;
    }

}
