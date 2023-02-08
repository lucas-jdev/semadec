package br.ifrn.semadec.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifrn.semadec.entities.edition.Edition;

public interface EditionRepository extends JpaRepository<Edition, UUID> {

    // TODO: implementar métodos de busca

}
