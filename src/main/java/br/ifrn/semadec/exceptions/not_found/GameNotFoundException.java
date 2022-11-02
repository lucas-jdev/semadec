package br.ifrn.semadec.exceptions.not_found;

import br.ifrn.semadec.exceptions.Exception;

@Exception(errorType = 3)
public class GameNotFoundException extends RuntimeException {
    private static final String MESSAGE = "Game not found";

    public GameNotFoundException() {
        super(MESSAGE);
    }

    public GameNotFoundException(String message) {
        super(message);
    }

}
