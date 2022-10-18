package br.ifrn.semadec.entities.sport;

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
public class Sport {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String name;
    private String categorySport;

    @Enumerated(EnumType.STRING)
    private CategoryGender categoryGender;

}
