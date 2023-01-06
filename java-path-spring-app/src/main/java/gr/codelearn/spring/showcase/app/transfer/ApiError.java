package gr.codelearn.spring.showcase.app.transfer;

import lombok.Value;

@Value
public class ApiError {
    Integer status;
    String message;
    String path;
}
