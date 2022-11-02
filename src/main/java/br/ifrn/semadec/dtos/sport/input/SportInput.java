package br.ifrn.semadec.dtos.sport.input;

import br.ifrn.semadec.dtos.course.input.CourseInput;
import br.ifrn.semadec.entities.sport.CategoryGender;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SportInput {

    private String name;
    private CategoryGender categoryGender;
    private String categorySport;
    private CourseInput courseInput;
    private int minTeams;
    private int maxTeams;

}
