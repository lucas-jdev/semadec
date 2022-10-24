package br.ifrn.semadec.dtos.course.input;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CourseInput {

    private String name;
    private String description;
    private String acronym;
    private Number score;
    private String colorPrimary;
    private String colorSecondary;
    private String level;
    private byte[] logo;
}
