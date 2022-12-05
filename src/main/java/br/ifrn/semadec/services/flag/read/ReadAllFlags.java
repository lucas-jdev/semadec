package br.ifrn.semadec.services.flag.read;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.entities.flag.Flag;
import br.ifrn.semadec.repositories.FlagRepository;

@Service
public class ReadAllFlags {

    @Autowired
    private FlagRepository flagRepository;

    public Collection<Flag> execute() {
        return flagRepository.findAll();
    }

}
