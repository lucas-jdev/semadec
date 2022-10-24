package br.ifrn.semadec.services.flag.update;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.entities.flag.Flag;
import br.ifrn.semadec.exceptions.not_found.FlagNotFoundException;
import br.ifrn.semadec.repositories.FlagRepository;

@Service
public class UpdateFlag {

    @Autowired
    private static FlagRepository flagRepository;

    private UpdateFlag() {
        throw new IllegalStateException("Service class");
    }

    public static Flag execute(final UUID id, final String name) {
        return flagRepository.findById(id)
                .map(flag -> _updateFlagWithDTO(flag, name))
                .map(flagRepository::save)
                .orElseThrow(FlagNotFoundException::new);
    }

    private static Flag _updateFlagWithDTO(final Flag flag, final String name) {
        flag.setName(name);
        return flag;
    }
}
