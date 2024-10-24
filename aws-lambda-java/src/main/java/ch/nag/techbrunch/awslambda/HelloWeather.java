package ch.nag.techbrunch.awslambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class HelloWeather implements RequestHandler<WeatherData, WeatherData> {

    @Override
    public WeatherData handleRequest(WeatherData weatherData, Context context) {


        // implement the logic to modify the weather data and add 2 degrees to the temperature
        // and return the modified weather data

        return null;
    }
}

record WeatherData(String location, int temperature) {
}