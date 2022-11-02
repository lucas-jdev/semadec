package br.ifrn.semadec.resolvers.course.query;

import java.util.UUID;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import br.ifrn.semadec.entities.course.Course;
import br.ifrn.semadec.services.course.read.ReadAllCourses;
import br.ifrn.semadec.services.course.read.ReadCourseById;
import br.ifrn.semadec.services.course.read.ReadCoursesByName;

@Controller
public class CourseQuery {

    @QueryMapping(name = "course")
    public Iterable<Course> findAll() {
        return ReadAllCourses.execute();
    }

    @QueryMapping(name = "course")
    public Course findById(String id) {
        final var uuid = UUID.fromString(id);
        return ReadCourseById.execute(uuid);
    }

    @QueryMapping
    public Iterable<Course> findByName(String name) {
        return ReadCoursesByName.execute(name);
    }

}
