package br.ifrn.semadec.resolvers.course.mutation;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import br.ifrn.semadec.dtos.course.input.CourseInput;
import br.ifrn.semadec.entities.course.Course;
import br.ifrn.semadec.services.course.create.CreateCourse;
import br.ifrn.semadec.services.course.update.UpdateCourse;

@Controller
public class CourseMutation {

    @Autowired
    private CreateCourse createCourse;

    @Autowired
    private UpdateCourse updateCourse;

    @MutationMapping
    public Course createCourse(CourseInput input) {
        return createCourse.execute(input);
    }

    @MutationMapping
    public Course updateCourse(String id, CourseInput input) {
        final var uuid = UUID.fromString(id);
        return updateCourse.execute(uuid, input);
    }

}
