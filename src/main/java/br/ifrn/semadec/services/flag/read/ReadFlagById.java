package br.ifrn.semadec.services.flag.read;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.entities.flag.Flag;
import br.ifrn.semadec.exceptions.not_found.FlagNotFoundException;
import br.ifrn.semadec.repositories.FlagRepository;

@Service
public class ReadFlagById {

    @Autowired
    private static FlagRepository flagRepository;

    private ReadFlagById() {
        throw new IllegalStateException("Service class");
    }

    public static Flag execute(final UUID id) {
        return flagRepository.findById(id)
                .orElseThrow(FlagNotFoundException::new);
    }
}
