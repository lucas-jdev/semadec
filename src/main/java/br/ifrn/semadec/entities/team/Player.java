package br.ifrn.semadec.entities.team;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.ifrn.semadec.entities.user.User;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name = "players")
public class Player {

    @Id
    @OneToOne
    private User user;

    private Number score;
    private int shirtNumber;
    private String position;

}
