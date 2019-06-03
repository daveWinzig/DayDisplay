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

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dave winzig
 */
public class CalendarEventLoader {

        public static ArrayList<CalendarEvent> readList()  {
        
            File file = new File("eventdata.dat");
            
            try ( FileInputStream fileIn = new FileInputStream(file);
                    ObjectInputStream objectIn = new ObjectInputStream(fileIn);) {

                //write to do list
                return (ArrayList<CalendarEvent>) objectIn.readObject();
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CalendarEventLoader.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            } catch (EOFException eof) {
                return null;
            } catch (FileNotFoundException ex) {
                Logger.getLogger(CalendarEventLoader.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            } catch (IOException ex) {
                Logger.getLogger(CalendarEventLoader.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }

            
    }
        
}
