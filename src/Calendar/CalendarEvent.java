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
import javafx.stage.Stage;
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
    private LocalTime dTime;
    
    public CalendarEvent(Stage primaryStage, String event) {
        
        this.event = event;
        cDate = LocalDate.now();
        cTime =  LocalTime.now();
        dDate = PopPicker.datePop(primaryStage);
       
    }

}
