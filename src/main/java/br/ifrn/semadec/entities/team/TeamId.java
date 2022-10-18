package br.ifrn.semadec.entities.team;

import javax.persistence.Embeddable;
import javax.persistence.OneToOne;

import br.ifrn.semadec.entities.course.Course;
import br.ifrn.semadec.entities.sport.Sport;

@Embeddable
public class TeamId {

    @OneToOne
    private Sport sport;

    @OneToOne
    private Course course;

}
