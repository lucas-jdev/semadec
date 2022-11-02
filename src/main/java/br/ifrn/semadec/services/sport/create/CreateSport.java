package br.ifrn.semadec.services.sport.create;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.dtos.sport.input.SportInput;
import br.ifrn.semadec.entities.sport.Sport;
import br.ifrn.semadec.repositories.SportRepository;

@Service
public class CreateSport {

    @Autowired
    private static SportRepository sportRepository;

    private CreateSport() {
        throw new IllegalStateException("Service class");
    }

    public static Sport execute(final SportInput input) {
        final Sport sport = _createSportWithDTO(input);
        return sportRepository.save(sport);
    }

    public static Sport _createSportWithDTO(SportInput input) {
        return Sport.builder()
                .name(input.getName())
                .categorySport(input.getCategorySport())
                .categoryGender(input.getCategoryGender())
                .minTeams(input.getMinTeams())
                .maxTeams(input.getMaxTeams())
                .build();
    }

}
