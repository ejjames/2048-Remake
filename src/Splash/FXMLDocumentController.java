package Splash;

import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;


public class FXMLDocumentController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane splashPane;

    @FXML
    private Button splashButton;

    @FXML
    private Label label;

    @FXML
    void handleButtonAction(ActionEvent event) {
 
        //splash screen section bushey demonstrated in class and was also a lab
        Parent root = null;
        FXMLLoader root1 = null;
        root1 = new FXMLLoader(getClass().getResource("FXML.fxml"));
        try {
            root = (Parent) root1.load();
        } catch (IOException ex) {
        }
        FXMLController controller = root1.<FXMLController>getController();
        controller.initialize("pixelbirb");//pixelbirb is the theme for my game ^-^
        Scene sc = new Scene(root);
        Stage st = new Stage();
        st.setScene(sc);
        st.show();
        splashPane.getScene().getWindow().hide();//hiding the splashpane here but it might be better to remove it, will look into this

    }

    public void playMusicWind() {
        URL resource = getClass().getResource("wind.mp3");
        MediaPlayer musicPlayer = new MediaPlayer((new Media(resource.toString())));
        musicPlayer.setOnEndOfMedia(new Runnable() {
            public void run() {
                musicPlayer.seek(javafx.util.Duration.ONE);
            }
        });
        musicPlayer.play();
    }

    @FXML
    void initialize() {
        playMusicWind();
        assert splashPane != null : "fx:id=\"splashPane\" was not injected: check your FXML file 'DogSplash.fxml'.";
        assert splashButton != null : "fx:id=\"splashButton\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'FXMLDocument.fxml'.";

    }

}
