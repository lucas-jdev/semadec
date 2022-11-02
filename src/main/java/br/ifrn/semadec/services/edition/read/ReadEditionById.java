package br.ifrn.semadec.services.edition.read;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.entities.edition.Edition;
import br.ifrn.semadec.exceptions.not_found.EditionNotFoundException;
import br.ifrn.semadec.repositories.EditionRepository;

@Service
public class ReadEditionById {

    @Autowired
    private static EditionRepository editionRepository;

    private ReadEditionById() {
        throw new IllegalStateException("Service class");
    }

    public static Edition execute(UUID id) {
        return editionRepository.findById(id)
                .orElseThrow(EditionNotFoundException::new);
    }

}
