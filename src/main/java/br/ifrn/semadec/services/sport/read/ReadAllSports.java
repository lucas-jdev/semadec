package br.ifrn.semadec.services.sport.read;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.entities.sport.Sport;
import br.ifrn.semadec.repositories.SportRepository;

@Service
public class ReadAllSports {

    @Autowired
    private static SportRepository sportRepository;

    private ReadAllSports() {
        throw new IllegalStateException("Service class");
    }

    public static Collection<Sport> execute() {
        return sportRepository.findAll();
    }

}