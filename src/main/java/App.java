import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * Created by sayemkcn on 1/1/17.
 */
public class App extends Application{

    public void start(Stage primaryStage){
        Button startButton = new Button("Start");
        final Button stopButton = new Button("Stop");
        final TextArea textArea = new TextArea();
        VBox vBox = new VBox();
        vBox.getChildren().add(startButton);
        vBox.getChildren().add(stopButton);
        vBox.getChildren().add(textArea);
        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.setTitle("HIT URL APP LOL");
        primaryStage.setResizable(true);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();

        startButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                textArea.setText("Starting connection..\n");
                new HttpCall("http://ab-pmo.herokuapp.com/",textArea);
            }
        });
        stopButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });

    }




}
