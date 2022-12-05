package br.ifrn.semadec.services.course.read;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.entities.course.Course;
import br.ifrn.semadec.exceptions.not_found.CourseNotFoundException;
import br.ifrn.semadec.repositories.CourseRepository;

@Service
public class ReadCourseById {

    @Autowired
    private CourseRepository courseRepository;

    public Course execute(final UUID id) {
        return courseRepository.findById(id)
                .orElseThrow(CourseNotFoundException::new);
    }

}
