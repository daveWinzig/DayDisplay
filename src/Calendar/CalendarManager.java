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
package Calendar;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 *
 * @author dave winzig
 */

//this class manages the creation and addition of calender events
public class CalendarManager {
    
    // Calendar Stuff
    private final Calendar calendar;

    
    //Constructor
    public CalendarManager() {
        
        calendar = new Calendar();

        
        //just for testing
        addEvent();
    }
    

    //create an event
    private CalendarEvent createEvent() {

        int year, month, day, hour,minute;
        String event;
                
        Random random = new Random();
        
        year = random.nextInt(100) + 2000;
        month = random.nextInt(12) + 1;
        day = random.nextInt(31) + 1;
        
        hour = random.nextInt(24);
        minute = random.nextInt(60);

        event = "Test";
        
        //temp hold date and time
        LocalDate dDate = LocalDate.of(year, month, day);
        LocalTime dTime = LocalTime.of(hour, minute);
        
        
        return new CalendarEvent(event, dDate, dTime);
        
        
    }
    
    //add an event
    public void addEvent() {
        
        //temp test code
        
        calendar.addEvent(createEvent());
        calendar.addEvent(createEvent());
        calendar.addEvent(createEvent());
        calendar.addEvent(createEvent());
        calendar.addEvent(createEvent());
        
    }
            
    //return gridlist of events
    public GridPane list() {
        
        //make the grid to be returned
        GridPane calPane = new GridPane();
        
        //get arraylist of events
        ArrayList<CalendarEvent> workingCal = calendar.getCalendarEvents();
        
        //make sure to only print 10 at a time
        int numEvents = (workingCal.size() < 10) ? workingCal.size(): 10;
        
        //loop through events and add to grid
        for(int i = 0; i < numEvents; i++) {
            
            Button button = new Button(String.valueOf(i + 1));
            button.setId("todoitemcheck");
            
            Text dateText = new Text(workingCal.get(i).getdTime().format(DateTimeFormatter.ofPattern("h mm a")));
            dateText.setId("todoitem");
            
            Text timeText = new Text(workingCal.get(i).getdDate().format(DateTimeFormatter.ofPattern("MMM dd")) );
            timeText.setId("todoitem");
            
            Text eventText = new Text(workingCal.get(i).getEvent());
            eventText.setId("todoitem");    
            
            calPane.addRow(i, button, dateText, timeText, eventText);
            
            
        }
        
                
        return calPane;
        
    }
    
    
}
