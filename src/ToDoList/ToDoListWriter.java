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
package ToDoList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author dave
 */
public class ToDoListWriter {
    
    public static void writeList(ArrayList<ToDoItem> toDoItems) throws FileNotFoundException, IOException {
        
        //file
        File file = new File("listdata.dat");
        
        //fileoutput
        FileOutputStream fileOut = new FileOutputStream(file);
        
        //object out
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        
        //write to do list
        objectOut.writeObject(toDoItems);
    }
}
