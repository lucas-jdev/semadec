package br.ifrn.semadec.services.game.update;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.dtos.game.input.GameInput;
import br.ifrn.semadec.dtos.team.input.TeamIdInput;
import br.ifrn.semadec.entities.course.Course;
import br.ifrn.semadec.entities.game.Game;
import br.ifrn.semadec.entities.score.Score;
import br.ifrn.semadec.entities.sport.Sport;
import br.ifrn.semadec.entities.team.Team;
import br.ifrn.semadec.entities.team.TeamId;
import br.ifrn.semadec.exceptions.not_found.CourseNotFoundException;
import br.ifrn.semadec.exceptions.not_found.GameNotFoundException;
import br.ifrn.semadec.exceptions.not_found.SportNotFoundException;
import br.ifrn.semadec.repositories.CourseRepository;
import br.ifrn.semadec.repositories.GameRepository;
import br.ifrn.semadec.repositories.SportRepository;
import br.ifrn.semadec.repositories.TeamRepository;

@Service
public class UpdateGame {

        @Autowired
        private GameRepository gameRepository;

        @Autowired
        private TeamRepository teamRepository;

        @Autowired
        private SportRepository sportRepository;

        @Autowired
        private CourseRepository courseRepository;

        public Game execute(UUID id, GameInput input) {
                Game game = gameRepository.findById(id)
                                .orElseThrow(GameNotFoundException::new);
                Game gameUpdated = _updateGameWithInput(game, input);
                return gameRepository.save(gameUpdated);
        }

        private Game _updateGameWithInput(Game game, final GameInput input) {
                List<Score> scores = input.getScores()
                                .stream()
                                .map(valueScore -> {
                                        return Score.builder().number(valueScore).build();
                                }).toList();

                UUID sportId = UUID.fromString(input.getSportId());
                Sport sport = sportRepository.findById(sportId)
                                .orElseThrow(SportNotFoundException::new);

                List<TeamId> teamsId = input.getTeamsId()
                                .stream()
                                .map(teamIdInput -> _createTeamIdByDTO(teamIdInput))
                                .toList();
                List<Team> teams = teamRepository.findAllById(teamsId);

                game.setScores(scores);
                game.setSport(sport);
                game.setTeams(teams);
                return game;
        }

        private TeamId _createTeamIdByDTO(TeamIdInput teamIdInput) {
                Sport sport = sportRepository.findById(teamIdInput.getSportId())
                                .orElseThrow(SportNotFoundException::new);

                Course course = courseRepository.findById(teamIdInput.getCourseId())
                                .orElseThrow(CourseNotFoundException::new);

                return TeamId.builder()
                                .sport(sport)
                                .course(course)
                                .build();
        }

}
