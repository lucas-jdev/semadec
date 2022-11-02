package br.ifrn.semadec.exceptions.not_found;

import br.ifrn.semadec.exceptions.Exception;

@Exception(errorType = 3)
public class EditionNotFoundException extends RuntimeException {

    private static final String MESSAGE = "Edition not found";

    public EditionNotFoundException() {
        super(MESSAGE);
    }

    public EditionNotFoundException(String message) {
        super(message);
    }

}
