package ch.nag.techbrunch.awslambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayV2HTTPEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayV2HTTPResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;


public class HelloApi implements RequestHandler<APIGatewayV2HTTPEvent, APIGatewayV2HTTPResponse> {

    @Override
    public APIGatewayV2HTTPResponse handleRequest(APIGatewayV2HTTPEvent event, Context context) {
        LambdaLogger logger = context.getLogger();
        logger.log("EVENT TYPE: " + event.getClass());
        APIGatewayV2HTTPResponse response = new APIGatewayV2HTTPResponse();
        try {
            logger.log("EVENT BODY: " + event.getBody());
            ObjectMapper objectMapper = new ObjectMapper();
            WeatherData weather = objectMapper.readValue(event.getBody(), WeatherData.class);

            WeatherData weatherResponse = new WeatherData(weather.location(), weather.temperature() + 2);

            response.setIsBase64Encoded(false);
            response.setStatusCode(200);
            HashMap<String, String> headers = new HashMap<String, String>();
            headers.put("Content-Type", "application/json");
            response.setHeaders(headers);
            response.setBody(objectMapper.writeValueAsString(weatherResponse));

        } catch (JsonProcessingException e) {
            response.setStatusCode(400);
            return response;
        }
        return response;
    }
}