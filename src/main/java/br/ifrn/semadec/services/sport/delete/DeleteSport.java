package br.ifrn.semadec.services.sport.delete;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.repositories.SportRepository;

@Service
public class DeleteSport {

    @Autowired
    private static SportRepository sportRepository;

    private DeleteSport() {
        throw new IllegalStateException("Service class");
    }

    public static void execute(final UUID id) {
        sportRepository.deleteById(id);
    }

}
