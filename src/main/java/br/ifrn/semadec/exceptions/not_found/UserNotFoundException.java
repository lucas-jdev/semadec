package br.ifrn.semadec.exceptions.not_found;

import br.ifrn.semadec.exceptions.Exception;

@Exception(errorType = 3)
public class UserNotFoundException extends RuntimeException {

    private static final String MESSAGE = "User not found";

    public UserNotFoundException(final String message) {
        super(message);
    }

    public UserNotFoundException() {
        super(MESSAGE);
    }

}
