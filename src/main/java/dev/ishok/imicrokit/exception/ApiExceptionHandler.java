package dev.ishok.imicrokit.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class ApiExceptionHandler {
  @ExceptionHandler(value = ApiRequestException.class)
  public ResponseEntity<Object> handleApiRequestException(ApiRequestException e) {
    HttpStatus badRequest = HttpStatus.BAD_REQUEST;
    log.error(e.getMessage(), e);
    ApiException exception = new ApiException(e.getMessage(), badRequest, badRequest.value(), ZonedDateTime.now(ZoneId.of("Z")));
    return new ResponseEntity<Object>(exception, badRequest);
  }

  @ExceptionHandler(value = NotFoundException.class)
  public ResponseEntity<Object> handleNotFoundException(NotFoundException e) {
    HttpStatus badRequest = HttpStatus.NOT_FOUND;
    log.error(e.getMessage(), e);
    ApiException exception = new ApiException(e.getMessage(), badRequest, badRequest.value(), ZonedDateTime.now(ZoneId.of("Z")));
    return new ResponseEntity<Object>(exception, badRequest);
  }

  @ExceptionHandler(value = AlreadyExistException.class)
  public ResponseEntity<Object> handleAlreadyExistException(AlreadyExistException e) {
    HttpStatus badRequest = HttpStatus.NOT_ACCEPTABLE;
    log.error(e.getMessage(), e);
    ApiException exception = new ApiException(e.getMessage(), badRequest, badRequest.value(), ZonedDateTime.now(ZoneId.of("Z")));
    return new ResponseEntity<Object>(exception, badRequest);
  }
}
