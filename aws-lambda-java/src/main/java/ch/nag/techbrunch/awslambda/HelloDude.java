package ch.nag.techbrunch.awslambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class HelloDude implements RequestHandler<Object, String> {
    @Override
    public String handleRequest(Object input, Context context) {

        // use a LambdaLogger to log the input and the type of the input
        // and return the object as String

        return "";
    }
}
