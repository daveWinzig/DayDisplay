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
import java.util.Collections;
import java.util.Random;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 *
 * @author dave winzig
 */

//this class manages the creation and addition of calender events
public final class CalendarManager {
    
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
        
        
    }
            
    //return gridlist of events
    public GridPane list() {
        
        //sort calendar
        sortCalendar();
        
        //make the grid to be returned
        GridPane calPane = new GridPane();
        
        //get arraylist of events
        ArrayList<CalendarEvent> workingCal = calendar.getCalendarEvents();
        
        //make sure to only print 10 at a time
        int numEvents = (workingCal.size() < 10) ? workingCal.size(): 10;
        
        //loop through events and add to grid
        for(int i = 0; i < numEvents; i++) {
            
            Label dateText = new Label(workingCal.get(i).getdTime().format(DateTimeFormatter.ofPattern("hh:mm a")));
            dateText.setId("eventtime");
            
            Label timeText = new Label(workingCal.get(i).getdDate().format(DateTimeFormatter.ofPattern("MMM dd yyyy")) );
            timeText.setId("eventdate");
            
            Label eventText = new Label(workingCal.get(i).getEvent());
            eventText.setId("eventtext");    
            
            calPane.addRow(i, timeText, dateText, eventText);
            
            
        }
        
        
        
                
        return calPane;
        
    }
    
    public void sortCalendar() {
        Collections.sort(calendar.getCalendarEvents(), new CalendarComparator());
    }
    
    
}
