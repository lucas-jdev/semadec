package br.ifrn.semadec.entities.score;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name = "scores")
public class Score {

    private UUID id;
    private Number number;

}
