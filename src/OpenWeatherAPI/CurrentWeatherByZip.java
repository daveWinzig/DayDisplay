/*
 * Copyright (C) 2019 dave
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

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/*
Author: Dave Winzig
Date Created: 5-14-19
Abstract: Facilitate a call to the OpenWeatherAPI for the purpose of getting
the current weather of a given city.
*/
public class CurrentWeatherByZip {
    
    //data members
    Map<String,String> parameters; //map of parameters to add to url
    private final APICall api; //calls the api
      
    public CurrentWeatherByZip (String zip) {
        
        //create the map
        parameters = new HashMap();
        
        //add the zip parameter
        parameters.put("zip", zip);
        
        //pass the map to the api for parsing 
        api = new APICall(parameters);

    }
    
    public JSONObject getWeather() {
        
        //JSON to hold api return
        JSONObject allWeather = null;
        
        try {
            allWeather = api.readJsonFromUrl();
            
        } catch (IOException ex) {
            Logger.getLogger(CurrentWeatherByZip.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(CurrentWeatherByZip.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return allWeather;
        
    }
    
    
}
