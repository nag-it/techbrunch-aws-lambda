package ch.nag.techbrunch.awslambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class HelloDude implements RequestHandler<Object, String> {
    @Override
    public String handleRequest(Object input, Context context) {
        LambdaLogger logger = context.getLogger();
        logger.log("EVENT TYPE: " + input.getClass());
        logger.log("EVENT INPUT: " + input);
        return "Hello " + input;
    }
}
