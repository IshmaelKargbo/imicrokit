package dev.ishok.imicrokit.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiException {
  private final String message;
  private final HttpStatus status;
  private final int statusCode;
  private final ZonedDateTime timestamp;
}
