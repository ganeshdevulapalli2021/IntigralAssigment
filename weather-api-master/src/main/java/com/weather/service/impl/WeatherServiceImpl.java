/**
 * Tata Elxsi, A TATA Group. All rights reserved.
 */

package com.weather.service.impl;

import com.weather.service.WeatherService;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author ganesh.d
 *
 */
@Service("weatherService")
public class WeatherServiceImpl implements WeatherService {

    private static final Logger logger = LoggerFactory.getLogger(WeatherService.class);

    @Value("${app.weather.api.key}")
    private String appkey;

    @Override
    public Object getWeatherByCity(String city, String country) throws IOException {
        logger.info("Requesting current weather for {}/{}", city, country);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> response = restTemplate.getForEntity(
                "https://api.openweathermap.org/data/2.5/weather?q=" + city + "," + country + "&appkey=" + appkey, Object.class);

        return response;
    }

    @Override
    public Object getWeatherByLocation(String lat, String lon) throws IOException {
        logger.info("Requesting current weather location for {}/{}", lat, lon);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> response = restTemplate.getForEntity(
                "https://api.openweathermap.org/data/2.5/forecast?lat=" + lat + "&lon=" + lon + "&appkey=" + appkey,
                Object.class);

        return response;
    }

}
