package br.ifrn.semadec.services.record.read;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.entities.record.Record;
import br.ifrn.semadec.exceptions.not_found.RecordNotFoundException;
import br.ifrn.semadec.repositories.RecordRepository;

@Service
public class ReadRecordById {

    @Autowired
    private static RecordRepository recordRepository;

    private ReadRecordById() {
        throw new IllegalStateException("Service class");
    }

    public static Record execute(UUID id) {
        return recordRepository.findById(id)
                .orElseThrow(RecordNotFoundException::new);
    }

}
