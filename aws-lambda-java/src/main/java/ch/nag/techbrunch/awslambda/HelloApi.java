package ch.nag.techbrunch.awslambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayV2HTTPEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayV2HTTPResponse;

public class HelloApi implements RequestHandler<APIGatewayV2HTTPEvent, APIGatewayV2HTTPResponse> {

    @Override
    public APIGatewayV2HTTPResponse handleRequest(APIGatewayV2HTTPEvent event, Context context) {
        LambdaLogger logger = context.getLogger();
        logger.log("EVENT TYPE: " + event.getClass());
        APIGatewayV2HTTPResponse response = new APIGatewayV2HTTPResponse();

        // Implement the logic to modify the weather data and add 2 degrees to the temperature
        // you can use com.fasterxml.jackson.databind.ObjectMapper to serialize and deserialize JSON

        return response;
    }
}