package br.ifrn.semadec.exceptions.not_found;

import br.ifrn.semadec.exceptions.Exception;

@Exception(errorType = 3)
public class RecordNotFoundException extends RuntimeException {

    private static final String MESSAGE = "Record not found";

    public RecordNotFoundException() {
        super(MESSAGE);
    }

    public RecordNotFoundException(String message) {
        super(message);
    }

}
