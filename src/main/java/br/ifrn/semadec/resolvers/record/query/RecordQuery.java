package br.ifrn.semadec.resolvers.record.query;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import br.ifrn.semadec.entities.record.Record;
import br.ifrn.semadec.services.record.read.ReadAllRecords;
import br.ifrn.semadec.services.record.read.ReadRecordById;
import br.ifrn.semadec.services.record.read.ReadRecordByPlayerId;
import br.ifrn.semadec.services.record.read.ReadRecordsByPlayerFullName;
import br.ifrn.semadec.services.record.read.ReadRecordsByPlayerUsername;

@Controller
public class RecordQuery {

    @Autowired
    private ReadAllRecords readAllRecords;

    @Autowired
    private ReadRecordById readRecordById;

    @Autowired
    private ReadRecordByPlayerId readRecordByPlayerId;

    @Autowired
    private ReadRecordsByPlayerFullName readRecordsByPlayerFullName;

    @Autowired
    private ReadRecordsByPlayerUsername readRecordsByPlayerUsername;

    @QueryMapping(name = "record")
    public Record findById(@Argument String id) {
        final var uuid = UUID.fromString(id);
        return readRecordById.execute(uuid);
    }

    @QueryMapping(name = "records")
    public Iterable<Record> findAll() {
        return readAllRecords.execute();
    }

    @QueryMapping
    public Iterable<Record> findByPlayerFullName(@Argument String fullName) {
        final String nameFormatted = fullName.toLowerCase();
        return readRecordsByPlayerFullName.execute(nameFormatted);
    }

    @QueryMapping
    public Iterable<Record> findByPlayerUsername(@Argument String username) {
        final String usernameFormatted = username.toLowerCase();
        return readRecordsByPlayerUsername.execute(usernameFormatted);
    }

    @QueryMapping
    public Record findByPlayerId(String id) {
        final var uuid = UUID.fromString(id);
        return readRecordByPlayerId.execute(uuid);
    }

}
