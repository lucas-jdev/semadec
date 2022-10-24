package br.ifrn.semadec.services.sport.read;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.entities.sport.Sport;
import br.ifrn.semadec.repositories.SportRepository;

@Service
public class ReadSportByCategory {

    @Autowired
    private static SportRepository sportRepository;

    private ReadSportByCategory() {
        throw new IllegalStateException("Service class");
    }

    public static Collection<Sport> execute(final String category) {
        return sportRepository.findByCategory(category.toLowerCase());
    }

}
