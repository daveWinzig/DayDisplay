/*
 * Copyright (C) 2019 Dave Winzig
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

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.text.Text;
import javax.swing.JOptionPane;

/**
 *
 * @author dave
 */
public class ToDoList  {
    //data members
    private ArrayList<ToDoItem> toDoItems; //list of things to do
    
    //constructor
    public ToDoList() {

        toDoItems = ToDoListLoader.readList();

        if(toDoItems == null) {
            toDoItems = new ArrayList<>();
        }
    }
    
    //add an item - return ture if added
    public boolean addToDoItem(ToDoItem item) {
        
        boolean success = false;
        
        if(toDoItems.add(item)) { 
            success = true;
        }
        
        saveState();
        
        return success;
        
    }
    
    //add item - ask for deets - mostly for testing, i think
    public void addToDoItem(String text) {
      
        ToDoItem toDoItem = new ToDoItem(text);
        
        toDoItems.add(toDoItem);
        
        saveState();
    }
    
    //remove an item - from todo to completed
    public boolean completeItem(int index) {
        
        boolean success = false;
       
        toDoItems.remove(index);
        
        saveState();
        
        return success;
    }
    
   //get ToDoITem
    public Text getToDo(int index) {
        return (toDoItems.get(index)).getItem();
    }
    
    //get number of items in list
    public int getNumItems() {
        return toDoItems.size();
    }
    
    //save the current state of the list
    private void saveState() {
        
        try {
            ToDoListWriter.writeList(toDoItems);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Failed to save To Do List.");
        }
    }
    
}
