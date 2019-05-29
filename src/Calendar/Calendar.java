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

import java.util.ArrayList;

/**
 *
 * @author dave
 */
public class Calendar {
    
    //calendar data
    private final ArrayList<CalendarEvent> calendarEvents;
    
    //constructor
    public Calendar() {
        
        //make the arraylist of calendar events
        calendarEvents = new ArrayList<>();
        
        
    }

    //getter
    public ArrayList<CalendarEvent> getCalendarEvents() {
        return calendarEvents;
    }
    
    //add an event
    public void addEvent(CalendarEvent event) {
        calendarEvents.add(event);
    }
    
    //remove an event
    public void removeEvent(CalendarEvent event) {
        calendarEvents.remove(event);
    }
    
    
    
    
}
