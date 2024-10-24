package ch.nag.techbrunch.awslambda;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HelloTest {

    @Test
    void handleRequest() {
        Hello hello = new Hello();
        String result = hello.handleRequest(null, null);
        assertEquals("Hello from Lambda!", result);
    }
}