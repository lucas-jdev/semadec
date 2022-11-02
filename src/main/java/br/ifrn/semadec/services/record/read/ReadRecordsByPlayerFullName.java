package br.ifrn.semadec.services.record.read;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.entities.record.Record;

import br.ifrn.semadec.repositories.RecordRepository;

@Service
public class ReadRecordsByPlayerFullName {

    @Autowired
    private static RecordRepository recordRepository;

    private ReadRecordsByPlayerFullName() {
        throw new IllegalStateException("Service class");
    }

    public static Collection<Record> execute(String fullName) {
        return recordRepository.findByPlayerFullName(fullName);
    }

}
