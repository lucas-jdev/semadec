package br.ifrn.semadec.services.course.delete;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.repositories.CourseRepository;

@Service
public class DeleteCourse {

    @Autowired
    private CourseRepository courseRepository;

    public void execute(final UUID id) {
        courseRepository.deleteById(id);
    }

}
