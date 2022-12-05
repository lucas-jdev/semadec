package br.ifrn.semadec.services.record.delete;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.repositories.RecordRepository;

@Service
public class DeleteRecord {

    @Autowired
    private RecordRepository recordRepository;

    private DeleteRecord() {
        throw new IllegalStateException("Service class");
    }

    public void execute(UUID id) {
        recordRepository.deleteById(id);
    }

}
