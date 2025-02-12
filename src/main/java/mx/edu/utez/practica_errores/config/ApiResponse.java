package mx.edu.utez.practica_errores.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse {
    @JsonProperty("data")
    private Object data;

    @JsonProperty("status")
    private HttpStatus status;

    @JsonProperty("error")
    private boolean error;

    @JsonProperty("message")
    private String message;

    // Constructor para éxito
    public ApiResponse(Object data, HttpStatus status) {
        this.data = data;
        this.status = status;
    }

    // Constructor para error
    public ApiResponse(HttpStatus status, boolean error, String message) {
        this.status = status;
        this.error = error;
        this.message = message;
    }

    // Getters y Setters
    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
