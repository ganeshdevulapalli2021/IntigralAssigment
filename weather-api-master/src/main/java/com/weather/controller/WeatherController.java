/**
 * Tata Elxsi, A TATA Group. All rights reserved.
 */

package com.weather.controller;

import com.weather.constants.UrlPaths;
import com.weather.service.WeatherService;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ganesh.d
 *
 */
@RestController
@RequestMapping(UrlPaths.URL)
public class WeatherController {

    @Autowired
    @Qualifier("weatherService")
    private WeatherService weatherService;

    /**
     * <p>
     * Fetches details of weather using parameters city and country.
     * </p>
     *
     * @return details of all weather with request.
     * @throws IOException
     */
    @Cacheable(value = "getWeatherByCity", key = "#city + #country")
    @RequestMapping(method = RequestMethod.GET, value = "/byCity/{country}/{city}")
    public @ResponseBody Object getWeatherByCity(@PathVariable String city, @PathVariable String country) throws IOException {
        return this.weatherService.getWeatherByCity(city, country);

    }

    /**
     * <p>
     * Fetches details of forecast using parameters city and country.
     * </p>
     *
     * @return details of all forecast with request.
     * @throws IOException
     */
    @Cacheable(value = "getWeatherByLocation", key = "#lat + #lon")
    @RequestMapping(method = RequestMethod.GET, value = "/byLocation/{lat}/{lon}")
    public @ResponseBody Object getWeatherByLocation(@PathVariable String lat, @PathVariable String lon) throws IOException {
        return this.weatherService.getWeatherByLocation(lat, lon);

    }

}
