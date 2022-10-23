package br.ifrn.semadec.exceptions.not_found;

import graphql.ErrorType;

public interface ErroTypeFunction {

    static ErrorType getErrorType(int number) {
        return switch (number) {
            case 0 -> ErrorType.ExecutionAborted;
            case 1 -> ErrorType.InvalidSyntax;
            case 2 -> ErrorType.ValidationError;
            case 3 -> ErrorType.DataFetchingException;
            case 4 -> ErrorType.NullValueInNonNullableField;
            case 5 -> ErrorType.OperationNotSupported;
            default -> ErrorType.ExecutionAborted;
        };
    }
}
