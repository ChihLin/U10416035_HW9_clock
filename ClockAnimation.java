//U10416035 Cheng Chih Lin

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.util.Duration;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.Group;

public class ClockAnimation extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
	
    ClockPane clock = new ClockPane(); // Create a clock
	BorderPane pane = new BorderPane(); //create a pane
	
    // Create a handler for animation
    EventHandler<ActionEvent> eventHandler = e -> {
		clock.setCurrentTime(); // Set a new clock time
		//create a label to put the string(including year,month,date,hour,min and sec)
		String timeString = clock.getYear()+" / "+(clock.getMonth()+1)+ " / " + clock.getDate() +"  "+ clock.getHour() + ":" + clock.getMinute() 
		+ ":" + clock.getSecond();
		Label lblCurrentTime = new Label(timeString);
	 
		//put the clock and label in the pane
		pane.setCenter(clock);
		pane.setBottom(lblCurrentTime);
		BorderPane.setAlignment(lblCurrentTime, Pos.TOP_CENTER);
    };
	
    // Create an animation for a running clock
    Timeline animation = new Timeline(
      new KeyFrame(Duration.millis(1000), eventHandler));
    animation.setCycleCount(Timeline.INDEFINITE);
    animation.play(); // Start animation
    
    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 250, 250);
    primaryStage.setTitle("ClockAnimation"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
