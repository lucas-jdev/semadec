package br.ifrn.semadec.entities.record;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.ifrn.semadec.entities.course.Course;
import br.ifrn.semadec.entities.sport.Sport;
import br.ifrn.semadec.entities.team.Player;
import br.ifrn.semadec.entities.team.Team;
import lombok.Builder;
import lombok.Data;

/**
 * <p>
 * A Record is a class that represents a record of a game.
 * </p>
 * 
 * @author Lucas-dev-back
 *
 * @version 0.1
 * 
 * @see
 *      <dl>
 *      <dt>Attributes</dt>
 *      </dl>
 * 
 *      <ul>
 *      <li>{@linkplain Record#id id}: UUID</li>
 *      <li>{@linkplain Record#score score}: Number</li>
 *      <li>{@linkplain Record#description description}: String</li>
 *      <li>{@linkplain Record#date date}: LocalDateTime</li>
 *      <li>{@linkplain Record#sport sport}: Sport</li>
 *      <li>{@linkplain Record#course course}: Course</li>
 *      <li>{@linkplain Record#team team}: Team</li>
 *      <li>{@linkplain Record#player player}: Player</li>
 *      </ul>
 * 
 */
@Entity
@Data
@Builder
@Table(name = "records")
public class Record implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(columnDefinition = "decimal(10,2)")
    private Number score;

    private String description;

    @Column(columnDefinition = "timestamp")
    private LocalDateTime date;

    @OneToOne(optional = false)
    private Sport sport;

    @OneToOne(optional = false)
    private Course course;

    @OneToOne
    private Player player;

    @OneToOne
    private Team team;

}
