package br.ifrn.semadec.services.course.create;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.dtos.course.input.CourseInput;
import br.ifrn.semadec.entities.course.Course;
import br.ifrn.semadec.entities.course.LevelOfCourse;
import br.ifrn.semadec.repositories.CourseRepository;

@Service
public class CreateCourse {

    @Autowired
    private static CourseRepository courseRepository;

    private CreateCourse() {
        throw new IllegalStateException("Service class");
    }

    public static Course execute(final CourseInput input) {
        Course course = _createCourseWithDTO(input);
        return courseRepository.save(course);
    }

    public static Course _createCourseWithDTO(CourseInput input) {
        return Course.builder()
                .name(input.getName())
                .colorPrimary(input.getColorPrimary())
                .colorSecondary(input.getColorSecondary())
                .description(input.getDescription())
                .level(LevelOfCourse.valueOf(input.getLevel()))
                .score(input.getScore())
                .build();
    }
}
