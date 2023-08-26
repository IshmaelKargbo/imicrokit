package dev.ishok.imicrokit;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import dev.ishok.imicrokit.exception.NotFoundException;

@SpringBootTest
public class NotFoundExceptionTest {
    
    @Test
    void contextLoads() {
        Exception exception = assertThrows(NotFoundException.class, () -> {
            throw new NotFoundException("Ooops! not found");
        });

        // Check if exception is not null
        assertNotNull(exception);
        
        // Check error message
        String expectedMessage = "Ooops! not found";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
