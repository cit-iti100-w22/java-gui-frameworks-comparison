package thiagod.jgfc;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import thiagod.jgfc.window.JFXWindow;

public class Launcher extends Application {

    int count = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        JFXWindow window = new JFXWindow();
        
        Scene scene = new Scene(window);
        
        primaryStage.setTitle("OpenJFX");
        primaryStage.setHeight(600);
        primaryStage.setWidth(300);
        primaryStage.setScene(scene);
        
        
        primaryStage.show();
    }
}
