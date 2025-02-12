package mx.edu.utez.practica_errores.handlers;

import mx.edu.utez.practica_errores.config.ApiResponse;
import mx.edu.utez.practica_errores.exception.CustomNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Manejar error 404 - Recurso no encontrado (personalizado)
    @ExceptionHandler(CustomNotFoundException.class)
    public ResponseEntity<ApiResponse> handleCustomNotFoundException(CustomNotFoundException ex) {
        ApiResponse apiResponse = new ApiResponse(ex.getStatus(), true, ex.getMessage());
        return new ResponseEntity<>(apiResponse, ex.getStatus());
    }

    // Manejar error 404 - Recurso no encontrado (por no encontrar el controlador)
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ApiResponse> handleNotFound(NoHandlerFoundException ex) {
        ApiResponse apiResponse = new ApiResponse(HttpStatus.NOT_FOUND, true, "Recurso no encontrado");
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    // Manejar error 500 - Error interno del servidor
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ApiResponse> handleInternalServerError(Exception ex) {
        ApiResponse apiResponse = new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, true, "Error interno del servidor");
        return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
