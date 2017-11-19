/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trailheadsystems.csc380_owm_maven_driver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
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
        
        try
        {
            client.setAPPID(_ReadKey());
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
    
    private static String _ReadKey() throws IOException
    {
        String line;
        String key = null;
        try (
            InputStream fis = new FileInputStream("owm.key");
            InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
            BufferedReader br = new BufferedReader(isr);
        ) {

            while ((line = br.readLine()) != null) {
                key = line;
            }
        }
        return key;
    }
}



