package br.ifrn.semadec.resolvers.course.query;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import br.ifrn.semadec.entities.course.Course;
import br.ifrn.semadec.services.course.read.ReadAllCourses;
import br.ifrn.semadec.services.course.read.ReadCourseById;
import br.ifrn.semadec.services.course.read.ReadCoursesByName;

@Controller
public class CourseQuery {

    @Autowired
    private ReadAllCourses readAllCourses;

    @Autowired
    private ReadCourseById readCourseById;

    @Autowired
    private ReadCoursesByName readCoursesByName;

    @QueryMapping(name = "courses")
    public Iterable<Course> findAll() {
        return readAllCourses.execute();
    }

    @QueryMapping(name = "course")
    public Course findById(String id) {
        final var uuid = UUID.fromString(id);
        return readCourseById.execute(uuid);
    }

    @QueryMapping
    public Iterable<Course> findCourseByName(String name) {
        return readCoursesByName.execute(name);
    }

}
