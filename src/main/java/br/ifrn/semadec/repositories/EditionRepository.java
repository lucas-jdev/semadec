package br.ifrn.semadec.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ifrn.semadec.entities.edition.Edition;

@Repository
public interface EditionRepository extends JpaRepository<Edition, UUID> {

    // TODO: implementar métodos de busca

}
