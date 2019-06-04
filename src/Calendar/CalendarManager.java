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

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import java.time.Month;

/**
 *
 * @author dave winzig
 */

//this class manages the creation and addition of calender events
public final class CalendarManager {
    
    // Calendar Stuff
    private final Calendar calendar;
    private final int NUM_DISP = 5;

    
    //Constructor
    public CalendarManager() {
        
        calendar = new Calendar();

        
        //just for testing
        addEvent();
    }
    

//    //create an event
//    private CalendarEvent createEvent() {
//
//        
//        return new CalendarEvent(event, dDate, dTime);
//        
//        
//    }
    
    //add an event
    public void addEvent() {
        
        
    }
    
    //add an item via a button
    public Button addButton(GridPane calPane) {
        
        //create the + button
        Button addButton = new Button("+");
        addButton.setId("todoitemcheck"); 
        
        addButton.setOnAction(e -> {

            //relist the list
             //clear the 
        
        list(calPane);
        
        });
        
    return addButton;
    
    }
            
    //return gridlist of events
    public void list(GridPane calPane) {
        
        //sort calendar
        sortCalendar();
        
        //clear the current display list
        calPane.getChildren().clear();
        
        //get arraylist of events
        ArrayList<CalendarEvent> workingCal = calendar.getCalendarEvents();
        
        //make sure to only print 10 at a time
        int numEvents = (workingCal.size() < NUM_DISP) ? workingCal.size(): NUM_DISP;
        
        //loop through events and add to grid
        int i;
        for(i = 0; i < numEvents; i++) {
            
            Label dateText = new Label(workingCal.get(i).getdTime().format(DateTimeFormatter.ofPattern("hh:mm a")));
            dateText.setId("eventtime");
            
            Label timeText = new Label(workingCal.get(i).getdDate().format(DateTimeFormatter.ofPattern("MMM dd yyyy")) );
            timeText.setId("eventdate");
            
            Label eventText = new Label(workingCal.get(i).getEvent());
            eventText.setId("eventtext");    
            
            calPane.addRow(i, timeText, dateText, eventText);
            
            
        }
        
        //add a row with empty slots to add a new event
        
        //month, day, year input - need validation
        ComboBox monthBox = new ComboBox();
        monthBox.setItems(FXCollections.observableArrayList(Month.values()));
        
        monthBox.valueProperty().addListener(listener);
        ComboBox dayBox = new ComboBox();
        dayBox.setItems(FXCollections.observableArrayList(Month.values()));
        
        //time input - need validation
        
        //event text input
        
        HBox addHBox = new HBox(addButton(calPane), monthBox);
        calPane.addRow(i, addHBox);


        
    }
    
    public void sortCalendar() {
        Collections.sort(calendar.getCalendarEvents(), new CalendarComparator());
    }
    
    
}
