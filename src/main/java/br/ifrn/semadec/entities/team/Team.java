package br.ifrn.semadec.entities.team;

import java.util.Set;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name = "teams")
public class Team {

    @EmbeddedId
    private TeamId id;

    @OneToMany
    private Set<Player> players;

}
