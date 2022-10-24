package br.ifrn.semadec.services.course.delete;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.semadec.repositories.CourseRepository;

@Service
public class DeleteCourse {

    @Autowired
    private static CourseRepository courseRepository;

    private DeleteCourse() {
        throw new IllegalStateException("Service class");
    }

    public static void execute(final UUID id) {
        courseRepository.deleteById(id);
    }

}
