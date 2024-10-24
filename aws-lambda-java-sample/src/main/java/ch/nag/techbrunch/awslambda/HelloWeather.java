package ch.nag.techbrunch.awslambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class HelloWeather implements RequestHandler<WeatherData, WeatherData> {

    @Override
    public WeatherData handleRequest(WeatherData weatherData, Context context) {
        LambdaLogger logger = context.getLogger();
        logger.log("EVENT TYPE: " + weatherData.getClass());
        return new WeatherData(weatherData.location(), weatherData.temperature() + 2);
    }
}

record WeatherData(String location, int temperature) {
}