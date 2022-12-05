package br.ifrn.semadec.services.course.read;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.entities.course.Course;
import br.ifrn.semadec.repositories.CourseRepository;

@Service
public class ReadAllCourses {

    @Autowired
    private CourseRepository courseRepository;

    public Collection<Course> execute() {
        return courseRepository.findAll();
    }

}
