/**
 * Tata Elxsi, A TATA Group. All rights reserved.
 */

package com.weather.service;

import java.io.IOException;

/**
 * @author ganesh.d
 *
 */
public interface WeatherService {

    Object getWeatherByCity(String city, String country) throws IOException;

    Object getWeatherByLocation(String lat, String lon) throws IOException;
}
