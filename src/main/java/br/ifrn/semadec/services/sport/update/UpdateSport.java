package br.ifrn.semadec.services.sport.update;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.dtos.sport.input.SportInput;
import br.ifrn.semadec.entities.sport.Sport;
import br.ifrn.semadec.exceptions.not_found.SportNotFoundException;
import br.ifrn.semadec.repositories.SportRepository;

@Service
public class UpdateSport {

    @Autowired
    private SportRepository sportRepository;

    public Sport execute(final UUID id, final SportInput input) {
        return sportRepository.findById(id)
                .map(sport -> _updateSportWithDTO(sport, input))
                .map(sportRepository::save)
                .orElseThrow(SportNotFoundException::new);
    }

    private Sport _updateSportWithDTO(Sport sport, SportInput input) {
        sport.setName(input.getName());
        sport.setCategorySport(input.getCategorySport());
        sport.setCategoryGender(input.getCategoryGender());
        sport.setMinTeams(input.getMinTeams());
        sport.setMaxTeams(input.getMaxTeams());
        return sport;
    }
}
