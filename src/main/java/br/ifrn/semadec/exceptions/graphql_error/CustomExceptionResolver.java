package br.ifrn.semadec.exceptions.graphql_error;

import java.util.Arrays;
import java.util.List;
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
        exception.printStackTrace();
        return toGraphQLError(exception, environment);
    }

    @Override
    protected List<GraphQLError> resolveToMultipleErrors(Throwable exception, DataFetchingEnvironment environment) {
        exception.printStackTrace();
        return List.of(toGraphQLError(exception, environment));
    }

    private GraphQLError toGraphQLError(Throwable exception, DataFetchingEnvironment environment) {
        return GraphqlErrorBuilder.newError()
                .message(exception.getMessage())
                .path(environment.getExecutionStepInfo().getPath())
                .location(environment.getField().getSourceLocation())
                .build();
    }

}
