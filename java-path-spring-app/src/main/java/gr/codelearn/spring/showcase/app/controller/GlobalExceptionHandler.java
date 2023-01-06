package gr.codelearn.spring.showcase.app.controller;

import gr.codelearn.spring.showcase.app.base.AbstractLogComponent;
import gr.codelearn.spring.showcase.app.transfer.ApiError;
import gr.codelearn.spring.showcase.app.transfer.ApiResponse;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class GlobalExceptionHandler extends AbstractLogComponent {
    private static final String URI_PATH_STR = "uri=";

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<?> handleException(final Exception ex, final WebRequest webRequest) {
        logger.error("An unexpected exception was thrown.", ex);

        return new ResponseEntity<>(ApiResponse.builder().apiError(getApiError(ex, HttpStatus.INTERNAL_SERVER_ERROR, webRequest, null)).build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<ApiResponse<?>> handleValidationException(final Exception ex, final WebRequest webRequest) {
        logger.error("A field is not valid.", ex);

        return new ResponseEntity<>(ApiResponse.builder().apiError(getApiError(ex, HttpStatus.BAD_REQUEST, webRequest, null)).build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataAccessException.class)
    public final ResponseEntity<ApiResponse<?>> handleDataErrors(final DataAccessException ex,
                                                                 final WebRequest request) {
        logger.error("There was something wrong while interacting with the associated database.", ex);
        return new ResponseEntity<>(
                ApiResponse.builder().apiError(getApiError(ex, HttpStatus.NOT_ACCEPTABLE, request, null)).build(),
                HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public final ResponseEntity<ApiResponse<?>> handleDataConstraintErrors(final DataIntegrityViolationException ex,
                                                                           final WebRequest request) {
        var customMessage = "There was a conflict while interacting with the associated database. Make sure the " +
                "data submitted does not include already existing values in fields such as ids and serial numbers.";
        logger.error("{}", customMessage, ex);

        return new ResponseEntity<>(
                ApiResponse.builder().apiError(getApiError(ex, HttpStatus.NOT_ACCEPTABLE, request, customMessage))
                        .build(), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    protected ResponseEntity<ApiResponse<?>> handleMissingServletRequestParameter(
            final MissingServletRequestParameterException ex, final WebRequest request) {
        logger.error("There was a parameter missing from incoming request", ex);
        return new ResponseEntity<>(
                ApiResponse.builder().apiError(getApiError(ex, HttpStatus.BAD_REQUEST, request, null)).build(),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ApiResponse<?>> handleMethodArgumentTypeMismatch(final MethodArgumentTypeMismatchException ex,
                                                                           final WebRequest request) {
        logger.error("Method argument, although matched, is of wrong type.", ex);
        return new ResponseEntity<>(
                ApiResponse.builder().apiError(getApiError(ex, HttpStatus.BAD_REQUEST, request, null)).build(),
                HttpStatus.BAD_REQUEST);
    }

    private ApiError getApiError(final Exception ex, final HttpStatus httpStatus, final WebRequest webRequest, String customMessage) {
        String path = webRequest.getDescription(false);

        if(path.indexOf(URI_PATH_STR) == 0) {
            path = StringUtils.replace(path, URI_PATH_STR, "");
        }

        return new ApiError(httpStatus.value(), customMessage != null ? customMessage : ex.getMessage(), path);
    }
}
