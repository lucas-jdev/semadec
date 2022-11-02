package br.ifrn.semadec.exceptions.not_found;

import br.ifrn.semadec.exceptions.Exception;

@Exception(errorType = 3)
public class TeamNotFoundException extends RuntimeException {

    private static final String MESSAGE = "Team not found";

    public TeamNotFoundException(String message) {
        super(message);
    }

    public TeamNotFoundException() {
        super(MESSAGE);
    }

}
