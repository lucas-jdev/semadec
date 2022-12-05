package br.ifrn.semadec.resolvers.record.mutation;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import br.ifrn.semadec.dtos.record.input.RecordInput;
import br.ifrn.semadec.entities.record.Record;
import br.ifrn.semadec.services.record.create.CreateRecord;
import br.ifrn.semadec.services.record.update.UpdateRecord;

@Controller
public class RecordMutation {

    @Autowired
    private CreateRecord createRecord;

    @Autowired
    private UpdateRecord updateRecord;

    @MutationMapping
    public Record createRecord(RecordInput input) {
        return createRecord.execute(input);
    }

    @MutationMapping
    public Record updateRecord(String id, RecordInput input) {
        final var uuid = UUID.fromString(id);
        return updateRecord.execute(uuid, input);
    }

}
