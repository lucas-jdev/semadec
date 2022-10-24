package br.ifrn.semadec.exceptions.not_found;

import br.ifrn.semadec.exceptions.Exception;

@Exception(errorType = 3)
public class FlagNotFoundException extends RuntimeException {

    private static final String MESSAGE = "Flag not found";

    public FlagNotFoundException(String message) {
        super(message);
    }

    public FlagNotFoundException() {
        super(MESSAGE);
    }

}
