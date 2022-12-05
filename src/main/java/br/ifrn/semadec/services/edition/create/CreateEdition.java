package br.ifrn.semadec.services.edition.create;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.dtos.edition.input.EditionInput;
import br.ifrn.semadec.entities.edition.Edition;
import br.ifrn.semadec.entities.record.Record;
import br.ifrn.semadec.repositories.EditionRepository;
import br.ifrn.semadec.repositories.RecordRepository;

@Service
public class CreateEdition {

    @Autowired
    private EditionRepository editionRepository;

    @Autowired
    private RecordRepository recordRepository;

    public void execute(EditionInput input) {
        final Edition edition = _createEditionWithDTO(input);
        editionRepository.save(edition);
    }

    private Edition _createEditionWithDTO(EditionInput input) {
        LocalDate startDate = LocalDate.parse(input.getStartDate());
        LocalDate endDate = LocalDate.parse(input.getEndDate());

        Set<Record> records = _getRecords(input);

        return Edition.builder()
                .name(input.getName())
                .startDate(startDate)
                .endDate(endDate)
                .records(records)
                .build();
    }

    private Set<Record> _getRecords(EditionInput input) {
        return input.getRecords()
                .stream()
                .map(id -> {
                    UUID uuid = UUID.fromString(id);
                    return recordRepository.findById(uuid).get();
                })
                .collect(Collectors.toSet());
    }
}
