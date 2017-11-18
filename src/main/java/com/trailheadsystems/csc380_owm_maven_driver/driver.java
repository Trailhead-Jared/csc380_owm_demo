/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trailheadsystems.csc380_owm_maven_driver;

import java.io.IOException;
import org.bitpipeline.lib.owm.OwmClient;
import org.bitpipeline.lib.owm.StatusWeatherData;
import org.bitpipeline.lib.owm.WeatherStatusResponse;
import org.json.JSONException;


/**
 *
 * @author demo
 */
public class driver {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        OwmClient client = new OwmClient();
        client.setAPPID("094811eebe38978dd36f1c2c835a96e4");
        try
        {
            WeatherStatusResponse result = client.currentWeatherAtCity("Billings","Us");
            System.out.println(result.toString());
            if(result.hasWeatherStatus())
            {
                
                for(StatusWeatherData weatherData : result.getWeatherStatus())
                {
                    System.out.println(weatherData.getTemperature());
                    System.out.println(weatherData.getWindSpeed());
                }
            }
        }
        catch(IOException exception)
        {
            System.err.println(exception);
        }
        catch(JSONException exception)
        {
            System.err.println(exception);
        }
                
        
        
    }
}



