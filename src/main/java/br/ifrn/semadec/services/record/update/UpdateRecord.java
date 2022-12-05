package br.ifrn.semadec.services.record.update;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.dtos.record.input.RecordInput;
import br.ifrn.semadec.dtos.team.input.TeamIdInput;
import br.ifrn.semadec.entities.course.Course;
import br.ifrn.semadec.entities.record.Record;
import br.ifrn.semadec.entities.sport.Sport;
import br.ifrn.semadec.entities.team.Player;
import br.ifrn.semadec.entities.team.Team;
import br.ifrn.semadec.entities.team.TeamId;
import br.ifrn.semadec.exceptions.not_found.RecordNotFoundException;
import br.ifrn.semadec.repositories.CourseRepository;
import br.ifrn.semadec.repositories.PlayerRepository;
import br.ifrn.semadec.repositories.RecordRepository;
import br.ifrn.semadec.repositories.SportRepository;
import br.ifrn.semadec.repositories.TeamRepository;

@Service
public class UpdateRecord {

    @Autowired
    private RecordRepository recordRepository;

    @Autowired
    private SportRepository sportRepository;

    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private CourseRepository courseRepository;

    public Record execute(UUID id, RecordInput input) {
        final Record recordFound = recordRepository.findById(id)
                .orElseThrow(RecordNotFoundException::new);

        _builderRecord(recordFound, input);

        return recordRepository.save(recordFound);

    }

    private Team _buildTeamByInput(RecordInput input) {
        final var teamIdInputOptional = Optional.ofNullable(input.getTeamId());
        TeamId teamId = teamIdInputOptional.map(teamIdInput -> {
            return _builderTeamId(teamIdInput);
        }).orElseThrow();
        return teamRepository.findById(teamId).orElseThrow();
    }

    private TeamId _builderTeamId(final TeamIdInput teamIdInput) {
        final UUID sportId = teamIdInput.getSportId();
        final UUID courseId = teamIdInput.getCourseId();

        final var sport = sportRepository.findById(sportId).orElseThrow();
        final var course = courseRepository.findById(courseId).orElseThrow();

        return TeamId.builder()
                .sport(sport)
                .course(course)
                .build();
    }

    private Record _builderRecord(final Record recordFound, final RecordInput input) {
        final var sportId = UUID.fromString(input.getSportId());
        final var playerId = UUID.fromString(input.getPlayerId());
        final var courseId = UUID.fromString(input.getCourseId());

        final Sport sport = sportRepository.findById(sportId).orElseThrow();
        final Player player = playerRepository.findById(playerId).orElseThrow();
        final Course course = courseRepository.findById(courseId).orElseThrow();
        final Team team = _buildTeamByInput(input);

        final var date = LocalDateTime.parse(input.getDateTime());

        recordFound.setSport(sport);
        recordFound.setPlayer(player);
        recordFound.setCourse(course);
        recordFound.setTeam(team);
        recordFound.setDate(date);
        recordFound.setScore(input.getScore());
        recordFound.setDescription(input.getDescription());

        return null;
    }
}
