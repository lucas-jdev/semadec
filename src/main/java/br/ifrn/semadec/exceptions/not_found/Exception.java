package br.ifrn.semadec.exceptions.not_found;

import org.springframework.stereotype.Component;

@Component
public @interface Exception {

    /**
     * <ul>
     * <li>0 - ExecutionAborted</li>
     * <li>1 - InvalidSyntax</li>
     * <li>2 - ValidationError</li>
     * <li>3 - DataFetchingException</li>
     * <li>4 - NullValueInNonNullableField</li>
     * <li>5 - OperationNotSupported</li>
     */
    int errorType();
}
