/* TO DO
 * X Date Label
 * X Weather Display
 *   x Get weather from API
 *   - Make weather images
 * - To Do List - may try for google taks api as well as local events?
 *   - Organize by age (time since creation), or due date
 *   - Have ability to add recurring items
 *     - MAybe with an enum list of days to choose from? 
 * - Calendar - (may try for google calender api) as well as local events?
 *   - Have items have date and start and finish time
 *   - Display items as a list of events in a given day, by start time
 *   - Only items from current day are displayed
 *   - Events have an owner - display with event
 *   - Sample Event: 2:00 - 4:00 / Aiden / Karate Class / Location (if present)
 *   - Display owner and location only if present
 *   - Integrate meal plan into calender (just a special event?) special way to diplay?
 * - To Do List Management UI
 * - Calender Management UI
*/

package daydisplay;

//imports
import TimeAndDate.Date;
import TimeAndDate.Time;
import ToDoList.ListManager;
import ToDoList.ToDoList;
import Weather.Weather;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/*
Author: Dave Winzig
Project: Day Display - a program that is intended to run on a monitor and 
continuously display helpful information
    - Daily Schedule and ToDo - Google Calender API
    - Meal Plan - maybe an array of objects, not sure yet
    - Weather - wunderground api probably
    - Time and Date Display
    - hopefully more
Date Created: 5-9-19
*/

public class DayDisplay extends Application {

    //some data members
    private final String title = "Day Display";
    
    //main method - only launches gui
    public static void main(String[] args) {
        
        //launch the application
        launch(args);
               
    }
    
    @Override
    public void start(Stage primaryStage) {
        
        //stage layout stuff
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        primaryStage.setX(bounds.getMinX());
        primaryStage.setY(bounds.getMinY());
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());
        
        //set stage title
        primaryStage.setTitle(title);

        //set stage to fullscreen
        primaryStage.setFullScreen(true);
        
        //no borders or titlebar
        primaryStage.initStyle(StageStyle.UNDECORATED);
        
        //escape to exit
        primaryStage.addEventHandler(KeyEvent.KEY_RELEASED, (KeyEvent event) -> 
        {
            if (KeyCode.ESCAPE == event.getCode()) {
                primaryStage.close();
                }
        });
        
        //display window
        primaryStage.show();
        
        //Time, Date, and Weather -----------------------------------
        
            // Time and Date Block ---------------------------------------------
                
                //Date Block ---------------------------------------------------
                    
                    //create a date object
                    Date date = new Date();
                    Text dateLabel = date.getDate();
                    dateLabel.setId("date");
                    dateLabel.setBoundsType(TextBoundsType.VISUAL);
                    GridPane.setHalignment(dateLabel, HPos.LEFT);

                //Time Block ---------------------------------------------------
        
                    //create new time object
                    Time time = new Time();
                    Text timeLabel = time.getTime();
                    timeLabel.setId("time");
                    timeLabel.setBoundsType(TextBoundsType.VISUAL);
                    GridPane.setHalignment(timeLabel, HPos.RIGHT);
                    
                    HBox timeAndDate = new HBox(dateLabel, timeLabel);
                    timeAndDate.setSpacing(25);
                    

            // Weather Block ---------------------------------------------------

                //Weather object
                Weather weather = new Weather();

                //Current temp
                Text currentTemp = weather.getTemp();
                currentTemp.setId("temp");
                currentTemp.setLineSpacing(0);
                currentTemp.setBoundsType(TextBoundsType.VISUAL);

                
                //Weather type
                Text currentType = weather.getType();
                currentType.setId("type");
                currentType.setLineSpacing(0);
                currentType.setBoundsType(TextBoundsType.VISUAL);

        
                HBox weatherBar = new HBox(currentType, currentTemp);
                weatherBar.setSpacing(25);
                weatherBar.setAlignment(Pos.BOTTOM_LEFT);
                
        // End of Top Row - Time, Date, and Weather ----------------------------

        //Calendar, ToDo List, and Dinner Block -------------------
        
            //Calendar and Dinner Block
                
                // Calendar Block

                    //Calendar Label
                    Text calendarLabel = new Text("SCHEDULE");
                    calendarLabel.setId("calendartitle");
                    calendarLabel.setBoundsType(TextBoundsType.VISUAL);
                    GridPane.setHalignment(calendarLabel, HPos.LEFT);
                    GridPane.setValignment(calendarLabel, VPos.BOTTOM);
                    GridPane.setMargin(calendarLabel, new Insets(50, 0, 0, 0));
                    
                    Text calendarBox = new Text("CALENDAR DATA HERE");
                    calendarBox.setId("calendar");
                    //calendarBox.setBoundsType(TextBoundsType.VISUAL);
                    GridPane.setHalignment(calendarBox, HPos.LEFT);
                    GridPane.setValignment(calendarBox, VPos.TOP);
  
                // Dinner Plan Block

                    //TEMPORARY DINNER BLOCK
                    Label dinnerBox = new Label("DINNER HERE");
                    
                    //Dinner Alignment
                    GridPane.setHalignment(dinnerBox, HPos.RIGHT);
                    GridPane.setValignment(dinnerBox, VPos.TOP);
                    
                    
            // ToDo List Block(s) ----------------------------------------------

                //create to do list
                ToDoList toDoList = new ToDoList();
                
                //add some working data
//                toDoList.addToDoItem("Build a house");
//                toDoList.addToDoItem("Build a snowman");
//                toDoList.addToDoItem("Build a sand castle");
//                toDoList.addToDoItem("Build a pony");
//                toDoList.addToDoItem("Build a doghouse");
                
                //To Do List Label
                Text toDoListLabel = new Text("TO DO TODAY");
                toDoListLabel.setId("todotitle");
                toDoListLabel.setBoundsType(TextBoundsType.VISUAL);
                GridPane.setHalignment(toDoListLabel, HPos.LEFT);
                GridPane.setMargin(toDoListLabel, new Insets(50, 0, 0, 0));
                
                GridPane listPane = new GridPane();
                listPane.setId("todogrid");
                //listPane.setGridLinesVisible(true);
                
                listPane.setVgap(0);
                listPane.setHgap(15);

                //add first 10 to do items to display
                int numItems = 10;
                if(toDoList.getNumItems() < 10) {
                    numItems = toDoList.getNumItems();
                }
                
                //create to do list
                ListManager.list(listPane, toDoList);
                
                
        //End Bottom Row - Calendar, ToDo List, and Dinner Block ---------------
        
        //Grid Layout ----------------------------------------------------------
        GridPane frame = new GridPane();
        
            //general grid properties
                
                //css properties
                frame.setId("grid");           
                //frame.setGridLinesVisible(true);
                frame.setAlignment(Pos.TOP_LEFT);
                
            // Set column width and height
                ColumnConstraints col1 = new ColumnConstraints();
                col1.setPercentWidth(100);
                
                frame.getColumnConstraints().add(col1);

                //for row height
                RowConstraints row1 = new RowConstraints();
                row1.setPercentHeight(-1);

                RowConstraints row2 = new RowConstraints();
                row2.setPercentHeight(-1);

                RowConstraints row3 = new RowConstraints();
                row3.setPercentHeight(-1);

                RowConstraints row4 = new RowConstraints();
                row2.setPercentHeight(-1);

                frame.getRowConstraints().addAll(row1, row2, row3, row4);
     
            //Add componants to grid
                
                //row 1
                frame.add(timeAndDate, 0, 0);
                
                //row 2
                frame.add(weatherBar, 0, 1);
                
                //row 3
                frame.add(toDoListLabel, 0, 2);
                
                //row 4
                frame.add(listPane, 0, 3);
                
                //row 5
                frame.add(calendarLabel, 0, 4);
        
        //End Grid Layout ------------------------------------------------------
            
        //Scene stuff
             
            //layout scene
            Scene scene = new Scene(frame);
            
            //load the stylesheet
            scene.getStylesheets().add("daydisplay/stylesheet.css");    
            scene.getStylesheets().add("http://fonts.googleapis.com/css?family=Rajdhani:400,700");

            //set the scene
            primaryStage.setScene(scene);
        
    }//end start
    

}//end class
