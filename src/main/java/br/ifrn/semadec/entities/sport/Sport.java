package br.ifrn.semadec.entities.sport;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Sport implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String name;
    private String categorySport;
    private int minTeams;
    private int maxTeams;

    @Enumerated(EnumType.STRING)
    private CategoryGender categoryGender;

}
