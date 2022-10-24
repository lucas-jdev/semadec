package br.ifrn.semadec.exceptions.not_found;

import br.ifrn.semadec.exceptions.Exception;

@Exception(errorType = 3)
public class SportNotFoundException extends RuntimeException {

    private static final String MESSAGE = "Sport not found";

    public SportNotFoundException(final String message) {
        super(message);
    }

    public SportNotFoundException() {
        super(MESSAGE);
    }

}
