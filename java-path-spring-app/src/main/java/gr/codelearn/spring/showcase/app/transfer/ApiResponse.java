package gr.codelearn.spring.showcase.app.transfer;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Value;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Value
@Builder
public class ApiResponse<T> implements Serializable {
    String transactionId = UUID.randomUUID().toString().toUpperCase();

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss.SSS")
    Date createdAt = new Date();

    T data;

    ApiError apiError;
}
