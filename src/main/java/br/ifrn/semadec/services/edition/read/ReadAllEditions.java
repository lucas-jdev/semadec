package br.ifrn.semadec.services.edition.read;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.entities.edition.Edition;
import br.ifrn.semadec.repositories.EditionRepository;

@Service
public class ReadAllEditions {

    @Autowired
    private static EditionRepository editionRepository;

    private ReadAllEditions() {
        throw new IllegalStateException("Service class");
    }

    public static Collection<Edition> execute() {
        return editionRepository.findAll();
    }

}
