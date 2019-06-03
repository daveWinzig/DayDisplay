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
package Calendar;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author dave
 */

public class Calendar {
    
    //calendar data
    private ArrayList<CalendarEvent> calendarEvents;
    
    //constructor
    public Calendar() {
        
        calendarEvents = CalendarEventLoader.readList();

        if(calendarEvents == null) {
            calendarEvents = new ArrayList<>();
        }
    }

    //getter
    public ArrayList<CalendarEvent> getCalendarEvents() {
        return calendarEvents;
    }
    
    //add an event
    public void addEvent(CalendarEvent event) {
        calendarEvents.add(event);
        saveState();
    }
    
    //remove an event
    public void removeEvent(CalendarEvent event) {
        calendarEvents.remove(event);
        saveState();
    }
    
    public void removeEvent(int index) {
        calendarEvents.remove(index);
        saveState();
    }
    
        //save the current state of the list
    private void saveState() {
        
        try {
            CalendarWriter.writeList(calendarEvents);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Failed to save To Do List.");
        }
    }

}
