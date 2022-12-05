package br.ifrn.semadec.services.edition.update;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.entities.record.Record;
import br.ifrn.semadec.dtos.edition.input.EditionInput;
import br.ifrn.semadec.entities.edition.Edition;
import br.ifrn.semadec.exceptions.not_found.EditionNotFoundException;
import br.ifrn.semadec.repositories.EditionRepository;
import br.ifrn.semadec.repositories.RecordRepository;

@Service
public class UpdateEdition {

    @Autowired
    private EditionRepository editionRepository;

    @Autowired
    private RecordRepository recordRepository;

    public void execute(UUID id, EditionInput editionInput) {
        Edition edition = editionRepository.findById(id)
                .orElseThrow(EditionNotFoundException::new);

        LocalDate startDate = LocalDate.parse(editionInput.getStartDate());

        Set<Record> records = _getRecords(editionInput);

        edition.setName(editionInput.getName());
        edition.setStartDate(startDate);
        edition.setRecords(records);

        editionRepository.save(edition);
    }

    private Set<Record> _getRecords(EditionInput editionInput) {
        return editionInput.getRecords().stream().map(recordId -> {
            UUID uuid = UUID.fromString(recordId);
            return recordRepository.findById(uuid).get();
        }).collect(Collectors.toSet());
    }

}
