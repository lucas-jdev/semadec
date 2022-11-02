package br.ifrn.semadec.resolvers.record.query;

import java.util.UUID;

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

    @QueryMapping(name = "record")
    public Record findById(String id) {
        final var uuid = UUID.fromString(id);
        return ReadRecordById.execute(uuid);
    }

    @QueryMapping(name = "records")
    public Iterable<Record> findAll() {
        return ReadAllRecords.execute();
    }

    @QueryMapping
    public Iterable<Record> findByPlayerFullName(String fullName) {
        final String nameFormatted = fullName.toLowerCase();
        return ReadRecordsByPlayerFullName.execute(nameFormatted);
    }

    @QueryMapping
    public Iterable<Record> findByPlayerUsername(String username) {
        final String usernameFormatted = username.toLowerCase();
        return ReadRecordsByPlayerUsername.execute(usernameFormatted);
    }

    @QueryMapping
    public Record findByPlayerId(String id) {
        final var uuid = UUID.fromString(id);
        return ReadRecordByPlayerId.execute(uuid);
    }

}
