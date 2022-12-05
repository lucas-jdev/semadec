package br.ifrn.semadec.services.flag.delete;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.repositories.FlagRepository;

@Service
public class DeleteFlag {

    @Autowired
    private FlagRepository flagRepository;

    public void execute(final UUID id) {
        flagRepository.deleteById(id);
    }

}
