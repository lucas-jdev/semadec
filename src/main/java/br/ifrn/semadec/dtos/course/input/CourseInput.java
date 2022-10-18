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
    private byte[] logo;
}
