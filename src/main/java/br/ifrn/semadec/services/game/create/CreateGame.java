package br.ifrn.semadec.services.game.create;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.dtos.game.input.GameInput;
import br.ifrn.semadec.dtos.team.input.TeamIdInput;
import br.ifrn.semadec.entities.course.Course;
import br.ifrn.semadec.entities.game.Game;
import br.ifrn.semadec.entities.sport.Sport;
import br.ifrn.semadec.entities.team.Team;
import br.ifrn.semadec.entities.team.TeamId;
import br.ifrn.semadec.exceptions.not_found.CourseNotFoundException;
import br.ifrn.semadec.exceptions.not_found.SportNotFoundException;
import br.ifrn.semadec.repositories.CourseRepository;
import br.ifrn.semadec.repositories.GameRepository;
import br.ifrn.semadec.repositories.SportRepository;
import br.ifrn.semadec.repositories.TeamRepository;

@Service
public class CreateGame {

        @Autowired
        private GameRepository gameRepository;

        @Autowired
        private TeamRepository teamRepository;

        @Autowired
        private SportRepository sportRepository;

        @Autowired
        private CourseRepository courseRepository;

        public Game execute(GameInput input) {
                final Game game = _createGameWithDTO(input);
                return gameRepository.save(game);
        }

        private Game _createGameWithDTO(GameInput input) {

                UUID sportId = UUID.fromString(input.getSportId());
                Sport sport = sportRepository.findById(sportId)
                                .orElseThrow(SportNotFoundException::new);

                List<TeamId> teamsId = input.getTeamsId()
                                .stream()
                                .map(teamIdInput -> _createTeamIdByDTO(teamIdInput))
                                .toList();

                List<Team> teams = teamRepository.findAllById(teamsId);

                return Game.builder()
                                .teams(teams)
                                .date(LocalDateTime.parse(input.getDate()))
                                .sport(sport)
                                .build();
        }

        private TeamId _createTeamIdByDTO(TeamIdInput input) {
                Sport sport = sportRepository.findById(input.getSportId())
                                .orElseThrow(SportNotFoundException::new);

                Course course = courseRepository.findById(input.getCourseId())
                                .orElseThrow(CourseNotFoundException::new);

                return TeamId.builder()
                                .sport(sport)
                                .course(course)
                                .build();
        }
}
