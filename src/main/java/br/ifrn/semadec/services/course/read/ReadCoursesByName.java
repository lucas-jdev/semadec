package br.ifrn.semadec.services.course.read;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.entities.course.Course;
import br.ifrn.semadec.repositories.CourseRepository;

@Service
public class ReadCoursesByName {

    @Autowired
    private static CourseRepository courseRepository;

    private ReadCoursesByName() {
        throw new IllegalStateException("Service class");
    }

    public static Collection<Course> execute(final String name) {
        return courseRepository.findByName(name);
    }

}
