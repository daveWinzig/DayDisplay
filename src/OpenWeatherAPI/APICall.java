/*
 * Copyright (C) 2019 dave winzig
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package OpenWeatherAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/*
Author: Dave Winzig
Date Created: 5-14-19
Abstract: Facilitate a call to the OpenWeatherAPI for the purpose of getting
the current weather.
*/

public class APICall {
    
    private final String APIid = "08ae451ad0e5c2d6fc7dedde9e6260cb";
    private final Map <String, String> parameters;
    private URL url;
    private String callURL;
    private HttpURLConnection connect;
    private final String units = "imperial";
    
    public APICall(Map parameters) {
        
        //base url for call
        this.callURL = "http://api.openweathermap.org/data/2.5/weather?";
        
        //create key value pairs of parameters and values
        this.parameters = new HashMap(parameters);
        
        //make the call url
        buildURL();

    }
    
    private String readAll(Reader rd) throws IOException {
        
        StringBuilder sb = new StringBuilder();
        
        int cp;
        
        while ((cp = rd.read()) != -1) {
          sb.append((char) cp);
        }
        
        return sb.toString();
    }
    
    public JSONObject readJsonFromUrl() throws IOException, JSONException {
        
        try (InputStream is = new URL(callURL).openStream()) {
            
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            
            String jsonText = readAll(rd);
        
            JSONObject json = new JSONObject(jsonText);
            
            return json;
        }
    }
      
    private void buildURL() {

        parameters.put("appid", APIid);
        parameters.put("units", units);
        
        StringBuilder urlBuilder = new StringBuilder(callURL);
        
        for(Map.Entry<String, String> parameter: parameters.entrySet()) {
            urlBuilder.append(parameter.getKey());
            urlBuilder.append("=");
            urlBuilder.append(parameter.getValue());
            urlBuilder.append("&");
        }
        
        callURL = urlBuilder.substring(0, urlBuilder.length()-1);
        
        
        
    }
    
    
    
}
