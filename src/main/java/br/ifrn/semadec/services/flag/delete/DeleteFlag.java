package br.ifrn.semadec.services.flag.delete;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.repositories.FlagRepository;

@Service
public class DeleteFlag {

    @Autowired
    private static FlagRepository flagRepository;

    private DeleteFlag() {
        throw new IllegalStateException("Service class");
    }

    public static void execute(final UUID id) {
        flagRepository.deleteById(id);
    }

}
