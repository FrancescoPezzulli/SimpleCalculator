
package calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * @author locadmin
 */
public class Calculator extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/main.fxml"));     
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("CALCULATOR");
        stage.setResizable(false);
        stage.getIcons().add(new Image("file:data/icon.png"));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
