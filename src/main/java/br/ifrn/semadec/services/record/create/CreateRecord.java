package br.ifrn.semadec.services.record.create;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.entities.course.Course;
import br.ifrn.semadec.entities.record.Record;
import br.ifrn.semadec.entities.sport.Sport;
import br.ifrn.semadec.dtos.record.input.RecordInput;
import br.ifrn.semadec.dtos.team.input.TeamIdInput;
import br.ifrn.semadec.entities.team.Player;
import br.ifrn.semadec.entities.team.Team;
import br.ifrn.semadec.entities.team.TeamId;
import br.ifrn.semadec.repositories.CourseRepository;
import br.ifrn.semadec.repositories.PlayerRepository;
import br.ifrn.semadec.repositories.RecordRepository;
import br.ifrn.semadec.repositories.SportRepository;
import br.ifrn.semadec.repositories.TeamRepository;

@Service
public class CreateRecord {

    @Autowired
    private static RecordRepository recordRepository;

    @Autowired
    private static TeamRepository teamRepository;

    @Autowired
    private static SportRepository sportRepository;

    @Autowired
    private static CourseRepository courseRepository;

    @Autowired
    private static PlayerRepository playerRepository;

    private CreateRecord() {
        throw new IllegalStateException("Service class");
    }

    public static Record execute(RecordInput input) {
        final var teamIdInputOptional = Optional.ofNullable(input.getTeamId());
        TeamId teamId = teamIdInputOptional.map(teamIdInput -> {
            return _builderTeamId(teamIdInput);
        }).orElseThrow();
        Team teamFound = teamRepository.findById(teamId).orElseThrow();

        return recordRepository.save(_builderRecord(input, teamFound));
    }

    private static TeamId _builderTeamId(final TeamIdInput teamIdInput) {
        final UUID sportId = teamIdInput.getSportId();
        final UUID courseId = teamIdInput.getCourseId();

        final var sport = sportRepository.findById(sportId).orElseThrow();
        final var course = courseRepository.findById(courseId).orElseThrow();

        return TeamId.builder()
                .sport(sport)
                .course(course)
                .build();
    }

    private static Record _builderRecord(final RecordInput input, final Team team) {
        final var sportId = UUID.fromString(input.getSportId());
        final var playerId = UUID.fromString(input.getPlayerId());
        final var courseId = UUID.fromString(input.getCourseId());

        final Sport sport = sportRepository.findById(sportId).orElseThrow();
        final Player player = playerRepository.findById(playerId);
        final Course course = courseRepository.findById(courseId).orElseThrow();

        return Record.builder()
                .sport(sport)
                .course(course)
                .player(player)
                .team(team)
                .build();
    }
}
