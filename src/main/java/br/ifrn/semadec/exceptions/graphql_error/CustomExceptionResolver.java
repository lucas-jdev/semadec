package br.ifrn.semadec.exceptions.graphql_error;

import java.util.Optional;

import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;

import br.ifrn.semadec.exceptions.Exception;
import br.ifrn.semadec.exceptions.ErroTypeFunction;
import graphql.ErrorClassification;
import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;

@Component
public class CustomExceptionResolver extends DataFetcherExceptionResolverAdapter {

    @Override
    protected GraphQLError resolveToSingleError(Throwable exception, DataFetchingEnvironment environment) {
        return toGraphQLError(exception, environment);
    }

    private ErrorClassification getErrorClassification(Throwable exception) {
        Class<?> errorClass = exception.getClass();
        Exception annotation = errorClass.getAnnotation(Exception.class);

        return Optional.of(annotation)
                .map(this::toErrorTypeAnnotation)
                .orElse(null);
    }

    private ErrorType toErrorTypeAnnotation(Exception annotation) {
        return ErroTypeFunction.getErrorType(annotation.errorType());
    }

    private GraphQLError toGraphQLError(Throwable exception, DataFetchingEnvironment environment) {
        return GraphqlErrorBuilder.newError()
                .errorType(getErrorClassification(exception))
                .message(exception.getMessage())
                .path(environment.getExecutionStepInfo().getPath())
                .location(environment.getField().getSourceLocation())
                .build();
    }

}
