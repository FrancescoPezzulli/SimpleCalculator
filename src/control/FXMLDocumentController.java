package control;

import calculator.Calculator;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @author locadmin
 */
public class FXMLDocumentController extends Calculator implements Initializable {

    @FXML
    private AnchorPane ap;
    @FXML
    private TextField txtfield;
    @FXML
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnce, btnfratto, btnper, btnmeno, btnvirgola, btnpot, btnsx, btndx, btnuguale;
    @FXML
    private AnchorPane anp;
    @FXML
    private MenuItem exit, clear, about;

    String result = "";

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtfield.setStyle("-fx-focus-color: -fx-control-inner-background ; -fx-faint-focus-color: -fx-control-inner-background ;");
        result = "";
    }

    @FXML
    private void uguale(ActionEvent event) {
        if (txtfield.getText().charAt(0) == '0' || txtfield.getText().charAt(0) == '1' || txtfield.getText().charAt(0) == '2' || txtfield.getText().charAt(0) == '3' || txtfield.getText().charAt(0) == '4' || txtfield.getText().charAt(0) == '5' || txtfield.getText().charAt(0) == '6' || txtfield.getText().charAt(0) == '7' || txtfield.getText().charAt(0) == '8' || txtfield.getText().charAt(0) == '9' || txtfield.getText().charAt(0) == '(') {
            if (txtfield.getText().charAt(txtfield.getText().length() - 1) == '0' || txtfield.getText().charAt(txtfield.getText().length() - 1) == '1' || txtfield.getText().charAt(txtfield.getText().length() - 1) == '2' || txtfield.getText().charAt(txtfield.getText().length() - 1) == '3' || txtfield.getText().charAt(txtfield.getText().length() - 1) == '4' || txtfield.getText().charAt(txtfield.getText().length() - 1) == '5' || txtfield.getText().charAt(txtfield.getText().length() - 1) == '6' || txtfield.getText().charAt(txtfield.getText().length() - 1) == '7' || txtfield.getText().charAt(txtfield.getText().length() - 1) == '8' || txtfield.getText().charAt(txtfield.getText().length() - 1) == '9' || txtfield.getText().charAt(txtfield.getText().length() - 1) == ')') {
                try {
                    ScriptEngineManager factory = new ScriptEngineManager();
                    ScriptEngine engine = factory.getEngineByName("JavaScript");
                    Object obj = engine.eval(txtfield.getText());
                    if ("Infinity".equals(obj.toString())) {
                        txtfield.setDisable(true);
                        txtfield.setText(obj.toString());
                    } else {
                        txtfield.setText(obj.toString());
                    }

                } catch (ScriptException ex) {
                    txtfield.setDisable(true);
                    txtfield.setText("mmh, what?");
                }

//            } else if (txtfield.getText().charAt(txtfield.getText().length()-1)=='0') {
//                txtfield.setText("why 0?");
//                txtfield.setDisable(true);
//            } else {
//                txtfield.setText("???");
//                txtfield.setDisable(true);
//            }
//        } else {
//            txtfield.setText("i don't understand");
//            txtfield.setDisable(true);
//        }
            } else {
                txtfield.setDisable(true);
                txtfield.setText("sure it's okay?");
            }
        } else {
            txtfield.setDisable(true);
            txtfield.setText("be careful!");
        }
    }

    @FXML
    private void zero(ActionEvent event) {
        txtfield.setText(txtfield.getText() + "0");
    }

    @FXML
    private void uno(ActionEvent event) {
        txtfield.setText(txtfield.getText() + "1");
    }

    @FXML
    private void due(ActionEvent event) {
        txtfield.setText(txtfield.getText() + "2");
    }

    @FXML
    private void tre(ActionEvent event) {
        txtfield.setText(txtfield.getText() + "3");
    }

    @FXML
    private void quattro(ActionEvent event) {
        txtfield.setText(txtfield.getText() + "4");
    }

    @FXML
    private void cinque(ActionEvent event) {
        txtfield.setText(txtfield.getText() + "5");
    }

    @FXML
    private void sei(ActionEvent event) {
        txtfield.setText(txtfield.getText() + "6");
    }

    @FXML
    private void sette(ActionEvent event) {
        txtfield.setText(txtfield.getText() + "7");
    }

    @FXML
    private void otto(ActionEvent event) {
        txtfield.setText(txtfield.getText() + "8");
    }

    @FXML
    private void nove(ActionEvent event) {
        txtfield.setText(txtfield.getText() + "9");
    }

    @FXML
    private void ce(ActionEvent event) {
        txtfield.setText("");
        txtfield.setDisable(false);
    }

    @FXML
    private void fratto(ActionEvent event) {
        txtfield.setText(txtfield.getText() + "/");
    }

    @FXML
    private void piu(ActionEvent event) {
        txtfield.setText(txtfield.getText() + "+");
    }

    @FXML
    private void meno(ActionEvent event) {
        txtfield.setText(txtfield.getText() + "-");
    }

    @FXML
    private void per(ActionEvent event) {
        txtfield.setText(txtfield.getText() + "*");
    }

    @FXML
    private void virgola(ActionEvent event) {
        txtfield.setText(txtfield.getText() + ".");
    }

    @FXML
    private void parentesi1(ActionEvent event) {
        txtfield.setText(txtfield.getText() + "(");
    }

    @FXML
    private void parentesi2(ActionEvent event) {
        txtfield.setText(txtfield.getText() + ")");
    }

    @FXML
    private void doexit() {
        System.exit(0);
    }

    @FXML
    private void doclear() {
        txtfield.setText("");
    }

    @FXML
    private void doabout() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("About Dialog");
        alert.setHeaderText("Version: 1.1");
        alert.setContentText("created by Francesco Pezzulli");
        alert.showAndWait();
    }

}
