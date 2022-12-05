package br.ifrn.semadec.services.team.create;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.dtos.team.input.TeamInput;
import br.ifrn.semadec.entities.course.Course;
import br.ifrn.semadec.entities.score.Score;
import br.ifrn.semadec.entities.sport.Sport;
import br.ifrn.semadec.entities.team.Team;
import br.ifrn.semadec.entities.team.TeamId;
import br.ifrn.semadec.repositories.CourseRepository;
import br.ifrn.semadec.repositories.SportRepository;
import br.ifrn.semadec.repositories.TeamRepository;

@Service
public class CreateTeam {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private SportRepository sportRepository;

    @Autowired
    private CourseRepository courseRepository;

    public Team excute(TeamInput input) {
        Team team = _createTeamWithDTO(input);
        return teamRepository.save(team);
    }

    private Team _createTeamWithDTO(TeamInput input) {
        Optional<Sport> sportFindedById = sportRepository.findById(input.getTeamIdInput().getSportId());
        Optional<Course> courseFindedById = courseRepository.findById(input.getTeamIdInput().getCourseId());

        Score score = _builderScore(input.getScoreInstance());

        Sport sport = sportFindedById.orElse(null);
        Course course = courseFindedById.orElse(null);

        return _builderTeam(sport, course, score);
    }

    private Score _builderScore(Number number) {
        return Score.builder()
                .number(number)
                .build();
    }

    private Team _builderTeam(Sport sport, Course course, Score score) {
        return Team.builder()
                .id(TeamId.builder()
                        .sport(sport)
                        .course(course)
                        .build())
                .scoreInstance(score)
                .build();
    }

}
