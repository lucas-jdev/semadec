package br.ifrn.semadec.services.team.read;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.dtos.team.input.TeamIdInput;
import br.ifrn.semadec.entities.course.Course;
import br.ifrn.semadec.entities.sport.Sport;
import br.ifrn.semadec.entities.team.Team;
import br.ifrn.semadec.entities.team.TeamId;
import br.ifrn.semadec.exceptions.not_found.TeamNotFoundException;
import br.ifrn.semadec.repositories.CourseRepository;
import br.ifrn.semadec.repositories.SportRepository;
import br.ifrn.semadec.repositories.TeamRepository;

@Service
public class ReadTeamById {

    @Autowired
    private static TeamRepository teamRepository;

    @Autowired
    private static SportRepository sportRepository;

    @Autowired
    private static CourseRepository courseRepository;

    private ReadTeamById() {
        throw new IllegalStateException("Service class");
    }

    public static Team execute(TeamIdInput teamIdInput) {
        Sport sport = sportRepository.findById(teamIdInput.getSportId())
                .orElseThrow();
        Course course = courseRepository.findById(teamIdInput.getCourseId())
                .orElseThrow();

        return teamRepository.findById(_builderTeamId(sport, course))
                .orElseThrow(TeamNotFoundException::new);
    }

    private static TeamId _builderTeamId(Sport sport, Course course) {
        return TeamId.builder()
                .sport(sport)
                .course(course)
                .build();
    }

}
