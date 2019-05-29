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

import java.time.LocalDate;
import java.time.LocalTime;
/**
 *
 * @author dave winzig
 */
public class CalendarEvent {
    
    //attributes
    private final String event;
    private final LocalDate cDate;
    private final LocalTime cTime;
    private final LocalDate dDate;
    private final LocalTime dTime;
    
    //constructor
    public CalendarEvent(String event, LocalDate dDate, LocalTime dTime) {
        
        this.event = event;
        cDate = LocalDate.now();
        cTime =  LocalTime.now();
        this.dDate = dDate;
        this.dTime = dTime;
       
    }

    public String getEvent() {
        return event;
    }

    public LocalDate getcDate() {
        return cDate;
    }

    public LocalTime getcTime() {
        return cTime;
    }

    public LocalDate getdDate() {
        return dDate;
    }

    public LocalTime getdTime() {
        return dTime;
    }

    @Override
    public String toString() {
        return dDate + " " + dTime + " " + event;
    }
    
    
}
