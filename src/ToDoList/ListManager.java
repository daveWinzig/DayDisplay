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
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 *
 * @author david.winzig.2729
 */
public class ListManager {
    
    //clear an item from the list
    public static EventHandler clear(GridPane listPane, ToDoList toDoList, Button toDoButton, int index) {
        EventHandler toDoHandler = (EventHandler<ActionEvent>) (ActionEvent t) -> {
            
            //remove todo item from todo list
            toDoList.completeItem(index);
            
            //remake list
            list(listPane, toDoList);

        };
        
        return toDoHandler;
    }
    
    //add an item via a button
    public static Button addButton(GridPane listPane, ToDoList toDoList) {
        
        //create the + button
        Button addButton = new Button("+");
        addButton.setId("todoitemcheck");
        
        //gets the new item text
        TextInputDialog addItem = new TextInputDialog();
        
        addItem.setHeaderText("Enter new To Do Item");
        
        addButton.setOnAction(e -> {
            addItem.showAndWait();
            if(addItem.getEditor().getText() != null) {
                toDoList.addToDoItem(addItem.getEditor().getText());
                list(listPane, toDoList);
            }
            
    });
        
    return addButton;
    }
    
    public static void list(GridPane listPane, ToDoList toDoList) {
        
        listPane.getChildren().clear();
        
        int numItems = toDoList.getNumItems();
        
        if (numItems > 10)
            numItems = 10;

        //create to do list
        int i = 0;
        for(; i < numItems; i++) {

            Button toDoButton = new Button(String.valueOf(i + 1));
            toDoButton.setId("todoitemcheck");
            
            Text temp = toDoList.getToDo(i);
            temp.setId("todoitem");

            //handle the events
            EventHandler toDoHandler = ListManager.clear(listPane, toDoList, toDoButton, i);       
            toDoButton.setOnAction(toDoHandler);

            //add a new row to grid with button and text
            listPane.addRow(i, toDoButton, temp);
        }
        
        Text placeholder = new Text(" ");  
        placeholder.setId("todoitem");
        
        listPane.addRow(i, addButton(listPane, toDoList), placeholder);
                
    }
    
}
