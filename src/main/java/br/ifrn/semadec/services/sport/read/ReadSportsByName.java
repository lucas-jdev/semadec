package br.ifrn.semadec.services.sport.read;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.entities.sport.Sport;
import br.ifrn.semadec.repositories.SportRepository;

@Service
public class ReadSportsByName {

    @Autowired
    private SportRepository sportRepository;

    public Collection<Sport> execute(final String name) {
        return sportRepository.findByName(name);
    }

}
