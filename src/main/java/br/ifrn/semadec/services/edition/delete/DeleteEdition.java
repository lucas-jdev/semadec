package br.ifrn.semadec.services.edition.delete;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.repositories.EditionRepository;

@Service
public class DeleteEdition {

    @Autowired
    private EditionRepository editionRepository;

    public void execute(UUID id) {
        editionRepository.deleteById(id);
    }

}
