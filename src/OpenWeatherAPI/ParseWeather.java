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

import org.json.JSONObject;

/*
Author: Dave Winzig
Date Created: 5-14-19
Abstract: Gets and returns a specific weather 
parameter form a weather JSON object.
*/

public class ParseWeather {
    
    public static String getTemp(JSONObject allWeather) {
        
        //return current temp as int string
        int temp = allWeather.getJSONObject("main").getInt("temp");
        return Integer.toString(temp) + "°";
        
    }
    
    public static String getType(JSONObject allWeather) {
        
        //return current weather icon id
        return allWeather.getJSONArray("weather").getJSONObject(0).getString("main");
        
    }
    
    public static String getDescription(JSONObject allWeather) {
        
        //return current weather icon id
        return allWeather.getJSONArray("weather").getJSONObject(0).getString("description");
        
    }
    
    public static String getIconID(JSONObject allWeather) {
        
        //return current weather icon id
        return allWeather.getJSONArray("weather").getJSONObject(0).getString("icon");
        
    }
}
