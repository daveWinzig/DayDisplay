/*
 * Copyright (C) 2019 Dave Winzig
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
package TimeAndDate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 *
 * @author dave winzig
 */
public class Date {
    
    //class members
    private Text date;
    private DateFormat format;
    private final Timeline timeline;
    
    //constructor
    public Date() {
        date = new Text();
        format = new SimpleDateFormat( "EEE MMM dd" );
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), (ActionEvent event) -> {
            final Calendar cal = Calendar.getInstance();
            date.setText(format.format(cal.getTime()).toUpperCase());  
        }));  
        
        timeline.setCycleCount(Animation.INDEFINITE);  
        timeline.play(); 
        
    }

    public Text getDate() {
        return date;
    }
}
