package co.gov.cajaviviendapopular.inventoryservice.controller;

import co.gov.cajaviviendapopular.inventoryservice.exception.ProductQuantityNotAvailableException;
import co.gov.cajaviviendapopular.inventoryservice.model.ErrorMessage;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = {ProductQuantityNotAvailableException.class})
    public ResponseEntity<ErrorMessage> productQuantityNotAvailableException(ProductQuantityNotAvailableException ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                "ERROR",
                LocalDateTime.now().toString(),
                ex.getMessage(),
                "No hay unidades disponibles para esta compra");

        return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<ErrorMessage> productQuantityNotAvailableException(EntityNotFoundException ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                "ERROR",
                LocalDateTime.now().toString(),
                ex.getMessage(),
                "Producto no encontrado");

        return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
    }
}
