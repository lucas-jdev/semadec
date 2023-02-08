package br.ifrn.semadec.entities.team;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import br.ifrn.semadec.entities.user.User;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name = "players")
public class Player implements Serializable {

    @Id
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;

    @OneToOne
    @JoinColumn(name = "id")
    @MapsId
    private User user;

    private Number score;
    private int shirtNumber;
    private String position;

}
