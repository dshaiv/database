package bdexamlefx;

import static bdexamlefx.BDvetKlinika.rs;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;

public class Controller implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button bNext;
    @FXML
    private TextField tidAnimals;
    @FXML
    private TextField tnickname;
    @FXML
    private TextField tfullname;
    @FXML
    private TextField tyear;
    @FXML
    private TextField tidowner;
    @FXML
    private TextField tidanimaltype;
    @FXML
    private Button bPrev;
    @FXML
    private Button bAdd;
    @FXML
    private Button bDelete;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
       if (event.getSource()==bNext){
          try {
            if (rs.next()) {
                tidAnimals.setText(rs.getString("id_animal"));
                tnickname.setText(rs.getString("nickname"));
                tfullname.setText(rs.getString("fullname"));
                tyear.setText(rs.getString("year_of_birth"));
                tidowner.setText(rs.getString("id_owner"));
                tidanimaltype.setText(rs.getString("id_animal_type"));
                 bPrev.setDisable(false);
            }
            else
                bNext.setDisable(true);
               
            
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }}
       else{
       try {
            if (rs.previous()) {
                tidAnimals.setText(rs.getString("id_animal"));
                tnickname.setText(rs.getString("nickname"));
                tfullname.setText(rs.getString("fullname"));
                tyear.setText(rs.getString("year_of_birth"));
                tidowner.setText(rs.getString("id_owner"));
                tidanimaltype.setText(rs.getString("id_animal_type"));
                bNext.setDisable(false);
            }
            else
               bPrev.setDisable(true);
            
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            if (rs.next()) {
                tidAnimals.setText(rs.getString("id_animal"));
                tnickname.setText(rs.getString("nickname"));
                tfullname.setText(rs.getString("fullname"));
                tyear.setText(rs.getString("year_of_birth"));
                tidowner.setText(rs.getString("id_owner"));
                tidanimaltype.setText(rs.getString("id_animal_type"));
                 bPrev.setDisable(true);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
     @FXML
    private void handleButtonAction2(ActionEvent event2) {
             
    }
    @FXML
    private void handleButtonAction3(ActionEvent event3) {
   
    }
}
