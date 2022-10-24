package br.ifrn.semadec.exceptions.not_found;

import br.ifrn.semadec.exceptions.Exception;

@Exception(errorType = 3)
public class CourseNotFoundException extends RuntimeException {

    private static final String MESSAGE = "Course not found";

    public CourseNotFoundException() {
        super(MESSAGE);
    }

    public CourseNotFoundException(String message) {
        super(message);
    }

}
