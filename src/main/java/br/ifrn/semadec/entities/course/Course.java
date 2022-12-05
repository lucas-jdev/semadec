package br.ifrn.semadec.entities.course;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
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
public class Course implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String name;

    @Column(length = 1000)
    private String description;

    @Column(columnDefinition = "decimal(10,2)")
    private Number score;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private LevelOfCourse level;

    @Column(length = 7)
    private String colorPrimary;

    @Column(length = 7)
    private String colorSecondary;

}
