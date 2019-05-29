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
import javafx.scene.control.DatePicker;
import javafx.stage.Popup;
import javafx.stage.Stage;

/**
 *
 * @author dave
 */
public class PopPicker {
    
    public static LocalDate datePop(Stage primaryStage) {
        
        //actual popup
        Popup pop = new Popup();
        
        //some content for popup
        DatePicker dp = new DatePicker();
        
        //add datepicker to popup
        pop.getContent().add(dp);
        
        pop.show(primaryStage);
        
        return dp.getValue();
        
        
    }
}
