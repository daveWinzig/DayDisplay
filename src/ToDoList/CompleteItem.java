/*
 * Copyright (C) 2019 david.winzig.2729
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

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 *
 * @author david.winzig.2729
 */
public class CompleteItem {
    
    public static EventHandler clear(GridPane listPane, ToDoList toDoList, Button toDoButton, Text temp, int i) {
        EventHandler toDoHandler = (EventHandler<ActionEvent>) (ActionEvent t) -> {
            
            //visual remove items from list
            listPane.getChildren().remove(toDoButton);
            listPane.getChildren().remove(temp);
            
            //remove todo item from todo list
            toDoList.completeItem(i);
            
            //renumber remaining items
            for (Node n: listPane.getChildren()) {
                GridPane.getRowIndex(n);
                
            }
                
            
            
            

        };
        
        return toDoHandler;
    }
}
