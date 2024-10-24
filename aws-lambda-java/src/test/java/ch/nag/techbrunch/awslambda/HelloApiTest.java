package ch.nag.techbrunch.awslambda;

import com.amazonaws.services.lambda.runtime.events.APIGatewayV2HTTPEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayV2HTTPResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class HelloApiTest {

    private HelloApi helloApi;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        helloApi = new HelloApi();
        objectMapper = new ObjectMapper();
    }

    @Test
    void handleRequest_validWeatherData_returnsModifiedWeatherData() throws JsonProcessingException {
//        APIGatewayV2HTTPEvent event = new APIGatewayV2HTTPEvent();
//        WeatherData weatherData = new WeatherData("Zurich", 20);
//        event.setBody(objectMapper.writeValueAsString(weatherData));
//
//        APIGatewayV2HTTPResponse response = helloApi.handleRequest(event, new TestContext());
//
//        assertEquals(200, response.getStatusCode());
//        assertFalse(response.getIsBase64Encoded());
//        assertEquals("application/json", response.getHeaders().get("Content-Type"));
//        WeatherData responseData = objectMapper.readValue(response.getBody(), WeatherData.class);
//        assertEquals("Zurich", responseData.location());
//        assertEquals(22, responseData.temperature());
    }

    @Test
    void handleRequest_invalidJson_returnsBadRequest() {
//        APIGatewayV2HTTPEvent event = new APIGatewayV2HTTPEvent();
//        event.setBody("invalid json");
//
//        APIGatewayV2HTTPResponse response = helloApi.handleRequest(event, new TestContext());
//
//        assertEquals(400, response.getStatusCode());
    }

    @Test
    void handleRequest_emptyBody_returnsBadRequest() {
//        APIGatewayV2HTTPEvent event = new APIGatewayV2HTTPEvent();
//        event.setBody("");
//
//        APIGatewayV2HTTPResponse response = helloApi.handleRequest(event, new TestContext());
//
//        assertEquals(400, response.getStatusCode());
    }
}
