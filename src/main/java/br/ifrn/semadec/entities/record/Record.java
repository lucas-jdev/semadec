package br.ifrn.semadec.entities.record;

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
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name = "records")
public class Record {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(columnDefinition = "decimal(10,2)")
    private Number score;

    @Column(columnDefinition = "timestamp")
    private LocalDateTime date;

    @OneToOne
    private Sport sport;

    @OneToOne
    private Course course;

    @OneToOne
    private Player player;

}
