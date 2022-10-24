package br.ifrn.semadec.services.course.update;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.dtos.course.input.CourseInput;
import br.ifrn.semadec.entities.course.Course;
import br.ifrn.semadec.entities.course.LevelOfCourse;
import br.ifrn.semadec.exceptions.not_found.CourseNotFoundException;
import br.ifrn.semadec.repositories.CourseRepository;

@Service
public class UpdateCourse {

    @Autowired
    private static CourseRepository courseRepository;

    private UpdateCourse() {
        throw new IllegalStateException("Service class");
    }

    public static Course execute(final UUID id, final CourseInput input) {
        return courseRepository.findById(id)
                .map(c -> _updateCourseWithDTO(c, input))
                .map(courseRepository::save)
                .orElseThrow(CourseNotFoundException::new);
    }

    private static Course _updateCourseWithDTO(Course course, CourseInput input) {
        course.setName(input.getName());
        course.setColorPrimary(input.getColorPrimary());
        course.setColorSecondary(input.getColorSecondary());
        course.setDescription(input.getDescription());
        course.setLevel(LevelOfCourse.valueOf(input.getLevel()));
        course.setScore(input.getScore());
        return course;
    }
}
