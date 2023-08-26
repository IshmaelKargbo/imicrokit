package dev.ishok.imicrokit;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import dev.ishok.imicrokit.exception.ApiRequestException;

@SpringBootTest
public class ApiExecptionExceptionTest {

    @Test
    void contextLoads() {
        Exception exception = assertThrows(ApiRequestException.class, () -> {
            throw new ApiRequestException("Ooops!");
        });

        // Check if exception is not null
        assertNotNull(exception);
        
        // Check error message
        String expectedMessage = "Ooops!";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
