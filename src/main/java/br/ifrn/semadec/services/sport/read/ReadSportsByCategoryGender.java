package br.ifrn.semadec.services.sport.read;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.entities.sport.CategoryGender;
import br.ifrn.semadec.entities.sport.Sport;
import br.ifrn.semadec.repositories.SportRepository;

@Service
public class ReadSportsByCategoryGender {

    @Autowired
    private SportRepository sportRepository;

    public Collection<Sport> execute(final String category) {
        return sportRepository.findByCategoryGender(CategoryGender.valueOf(category.toUpperCase()));
    }

}
