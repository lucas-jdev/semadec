package br.ifrn.semadec.services.flag.create;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.entities.flag.Flag;
import br.ifrn.semadec.repositories.FlagRepository;

@Service
public class CreateFlag {

    @Autowired
    private static FlagRepository flagRepository;

    private CreateFlag() {
        throw new IllegalStateException("Service class");
    }

    public static Flag execute(String name) {
        Flag flag = Flag.builder().name(name).build();

        return flagRepository.save(flag);
    }
}
