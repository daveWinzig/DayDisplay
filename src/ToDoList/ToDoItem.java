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
import javafx.scene.text.Text;

/**
 *
 * @author dave winzig
 */

public class ToDoItem implements Serializable {
    
    //data members
    private String item;
    private final Calendar created;
    
    //default constructor
    public ToDoItem() {
        item = null;
        created = Calendar.getInstance();
    }
    
    //item with no users
    public ToDoItem(String item) {
        this.item = item;
        this.created = Calendar.getInstance();
    }

    //setters and getters
    public Text getItem() {
        
        return new Text(item);
    }

    public void setItem(String item) {
        this.item = item;
    }
    
    @Override
    public String toString() {
        return item;
    }
    
    
    
    
    
}
