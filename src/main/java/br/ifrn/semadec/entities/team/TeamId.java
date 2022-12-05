package br.ifrn.semadec.entities.team;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.OneToOne;

import br.ifrn.semadec.entities.course.Course;
import br.ifrn.semadec.entities.sport.Sport;
import lombok.Builder;

@Embeddable
@Builder
public class TeamId implements Serializable {

    @OneToOne
    private Sport sport;

    @OneToOne
    private Course course;

}
