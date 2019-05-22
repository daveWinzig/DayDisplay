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

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javafx.scene.text.Text;

/**
 *
 * @author dave winzig
 */

public class ToDoItem implements Serializable {
    
    //data members
    
    private String item;
    private Date dueDate; 
    private Calendar calTime;
    private final Date created;
    private boolean completed;
    
    //default constructor
    public ToDoItem() {
        item = null;
        created = calTime.getTime();
        completed = false;
    }
    
    //item with no users
    public ToDoItem(String item) {
        this.item = item;
        calTime = (Calendar) Calendar.getInstance();
        this.created = calTime.getTime();
        this.completed = false;
    }

    //setters and getters
    public Text getItem() {
        
        return new Text(item);
    }

    public void setItem(String item) {
        this.item = item;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    
    @Override
    public String toString() {
        return item;
    }
    
    
    
    
    
}
