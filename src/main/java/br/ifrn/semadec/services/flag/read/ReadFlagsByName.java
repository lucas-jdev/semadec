package br.ifrn.semadec.services.flag.read;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.entities.flag.Flag;
import br.ifrn.semadec.repositories.FlagRepository;

@Service
public class ReadFlagsByName {

    @Autowired
    private static FlagRepository flagRepository;

    private ReadFlagsByName() {
        throw new IllegalStateException("Service class");
    }

    public static Collection<Flag> execute(final String name) {
        return flagRepository.findByName(name);
    }
}
