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
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import java.time.Month;
import java.util.Calendar;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.geometry.Orientation;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.util.Duration;

/**
 *
 * @author dave winzig
 */

//this class manages the creation and addition of calender events
public final class CalendarManager {
    
    // Calendar Stuff
    private final EventCalendar calendar;
    private final int NUM_DISP = 10;
    private final FlowPane calendarPane;
    private Timeline timeline;
    private LocalDate today;

    
    //Constructor
    public CalendarManager() {

        //lets make a calendar - this contains all of our events
        calendar = new EventCalendar();
        
        //make the flowpane to hold events
        calendarPane = new FlowPane(Orientation.VERTICAL);
        calendarPane.getStyleClass().add("flowpane");
        
        //prime the date and list
        today = LocalDate.now();  
        list();
        
        //updating the date - to compare to the events for whether to display
        timeline = new Timeline(new KeyFrame(Duration.seconds(3600), (ActionEvent event) -> {

            //get the current date
            today = LocalDate.now();
            
            System.out.println(today);
            
            //list the items into the display flowpane
            list();
        }));  
        
        timeline.setCycleCount(Animation.INDEFINITE);  
        timeline.play(); 


        
    }
    
    //add an item via a button
    public Button addButton(ComboBox month, ComboBox day, TextField time, TextField event) {
        
        //create the + button
        Button addButton = new Button("+");
        addButton.setId("todoitemcheck"); 
        
        //button handler to add an event
        addButton.setOnAction(e -> {
            
            //date stuff
            int y = 2019; //year
            int m = month.getSelectionModel().getSelectedIndex() + 1; //month
            int d = (int) day.getSelectionModel().getSelectedItem(); //day
            
            //time stuff
            String [] timeArray = time.getText().split("[:| ]");
            int h = Integer.parseInt(timeArray[0]);
            int min = Integer.parseInt(timeArray[1]);
            
            //for turning 12-hour time to 24-hour time
            if(timeArray[2].equalsIgnoreCase("PM")) {
                h += 12;
            }

            //create the new event
            LocalDate date = LocalDate.of(y, m, d); //date
            LocalTime t = LocalTime.of(h, m); //time
            CalendarEvent tempEvent = new CalendarEvent(event.getText(), date, t);
            
            //add event
            calendar.addEvent(tempEvent);
            
            //this clears and relists the display flowpane in one swift action
            list();
        
        });
        
    return addButton;
    
    }
            
    //return gridlist of events
    public void list() {

        //sort calendar - this sorts by date and then time
        sortCalendar();
        
        //clear the current display list - only clears the observable list from 
        // the flowpane - not the actual list of items
        calendarPane.getChildren().clear();
        
        //get arraylist of events
        ArrayList<CalendarEvent> workingCal = calendar.getCalendarEvents();
        ArrayList<CalendarEvent> currentDisplayCal = new ArrayList<>();
        
        //make a list of events for a given day
        for(int i = 0; i < workingCal.size(); i++) {
            
            CalendarEvent e = workingCal.get(i);
            
            //if the event is in the past - get rid of it
            if(e.getdDate().isBefore(today)) {
                
                //remove
                workingCal.remove(e);
            }
            //if the event is today add it to display
            else if(e.getdDate().equals(today)) {
                
                //add
                currentDisplayCal.add(e);
            }
            
        }
        
        //make sure to only print 10 at a time
        int numEvents = (currentDisplayCal.size() < NUM_DISP) ? currentDisplayCal.size(): NUM_DISP;
        
        //loop through events and add to grid
        int i;
        for(i = 0; i < numEvents; i++) {
            
            //displays the date of an event
            Label dateText = new Label(currentDisplayCal.get(i).getdTime().format(DateTimeFormatter.ofPattern("hh:mm a")));
            dateText.setId("eventtime");
            
            //displays the time of an event
            Label timeText = new Label(currentDisplayCal.get(i).getdDate().format(DateTimeFormatter.ofPattern("MMM dd yyyy")) );
            timeText.setId("eventdate");
            
            //displays the text describing an event
            Text eventText = new Text(currentDisplayCal.get(i).getEvent());
            eventText.setBoundsType(TextBoundsType.VISUAL);
            eventText.setId("eventtext");    

            HBox eventTextPane = new HBox(eventText);
            eventTextPane.setId("eventtextbox");
            
            //hbox that contains a complete event - date, time, text
            HBox itemBox = new HBox(timeText, dateText, eventTextPane); 
            itemBox.setId("eventbox");
            
            //add the hbox to the flowpane
            calendarPane.getChildren().add(itemBox);
   
        }
        
        //combobox for month input
        ComboBox monthBox = new ComboBox();
        
        //combobox for date input
        ComboBox dayBox = new ComboBox();
        
        //set current month as default selection
        //this little bit of code gets the current month (Calendar) which is 
        //zero indexed, 1 must be added to get the month name from the Month enum
        //because that is not zero indexed
        {
            int monthInt = Calendar.getInstance().get(Calendar.MONTH);
            
            Month month = Month.of(monthInt + 1);
            
            monthBox.setValue(month);

            ArrayList<Integer> daylist = makeDayArray(month.maxLength());

            dayBox.setItems(FXCollections.observableArrayList(daylist));
            
            dayBox.setValue(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));

            monthBox.setItems(FXCollections.observableArrayList(Month.values()));
        }
        
        //handle updating the list of days in the combobox when a different 
        //month is selected
        monthBox.setOnAction((Event e) -> {
            
            Month month = (Month) monthBox.getSelectionModel().getSelectedItem();
            
            ArrayList<Integer> daylist = makeDayArray(month.maxLength());

            dayBox.setItems(FXCollections.observableArrayList(daylist));
            
        });

        //newValue.matches("[1-12]:[0-5][0-9] [PM|AM|pm|am]");
        
        //time input - need validation
        TextField timeText = new TextField();
        timeText.setText("0:00 PM");
        timeText.textProperty().addListener((observable, oldValue, newValue) -> {
           
                if(oldValue.matches("[1-12]")) {
                    newValue = oldValue.concat(":00 PM");
                    timeText.setText(newValue);
                }
                else if(oldValue.matches("[1-12]:[0-5]")) {
                    newValue = oldValue.concat("0 PM");
                    timeText.setText(newValue);
                }
                else if(oldValue.matches("[1-12]:[0-5][0-9]")) {
                    newValue = oldValue.concat(" PM");
                    timeText.setText(newValue);
                }
            
        });
        
        
        //event text input
        TextField eventText = new TextField();
        eventText.setText("add text...");
                
        //this hbox holds the input comboboxes 
        HBox addHBox = new HBox(addButton(monthBox,dayBox,timeText,eventText), monthBox, dayBox, timeText, eventText);
        addHBox.setId("addbuttonpane");
        
        calendarPane.getChildren().addAll(addHBox);

    }
    
    public void sortCalendar() {
        Collections.sort(calendar.getCalendarEvents(), new CalendarComparator());
    }
    
    private ArrayList<Integer> makeDayArray(int numDays) {
        
        ArrayList<Integer> dayArray = new ArrayList<>();
        for (int day = 1; day <= numDays; day++) {
            dayArray.add(day);
        }
        
        return dayArray;
    }

    public FlowPane getCalendarPane() {
        return calendarPane;
    }
    
    
}
