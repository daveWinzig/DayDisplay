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

package Weather;

import OpenWeatherAPI.CurrentWeatherByZip;
import OpenWeatherAPI.ParseWeather;
import java.util.Locale;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.text.Text;
import javafx.util.Duration;

/*
Author: Dave Winzig
Date Created: 5-14-19
Abstract: Create a javafx label with temp and with an icon.
*/

public class Weather {
    
    //data members
    CurrentWeatherByZip cw;
    private final String zip = "97520";
    private final Timeline timeline;
    private Text tempLabel;
    private Text typeLabel;
            
    public Weather() {

        cw = new CurrentWeatherByZip(zip);
        
        tempLabel = new Text(ParseWeather.getTemp(cw.getWeather()).toUpperCase());
        typeLabel = new Text(ParseWeather.getDescription(cw.getWeather()).toUpperCase());
        
        
        //fetches the temp hourly
        timeline = new Timeline(new KeyFrame(Duration.seconds(900), (ActionEvent event) -> {
            
            //gets the current temp
            tempLabel.setText(ParseWeather.getTemp(cw.getWeather()).toUpperCase()); 
            typeLabel.setText(ParseWeather.getDescription(cw.getWeather()).toUpperCase(Locale.FRENCH));
   
        }));  
        
        timeline.setCycleCount(Animation.INDEFINITE);  
        timeline.play(); 
    }
    
    public Text getTemp() {
        return tempLabel;
    }
    
    public Text getType() {
        return typeLabel;
    }
    
}
