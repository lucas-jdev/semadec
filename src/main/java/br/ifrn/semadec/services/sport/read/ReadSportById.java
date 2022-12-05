package br.ifrn.semadec.services.sport.read;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.entities.sport.Sport;
import br.ifrn.semadec.exceptions.not_found.SportNotFoundException;
import br.ifrn.semadec.repositories.SportRepository;

@Service
public class ReadSportById {

    @Autowired
    private SportRepository sportRepository;

    public Sport execute(final UUID id) {
        return sportRepository.findById(id)
                .orElseThrow(SportNotFoundException::new);
    }

}
