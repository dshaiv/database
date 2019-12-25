package bdexamlefx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



 public class BDvetKlinika extends Application {
    private static final  String url = "jdbc:mysql://localhost/vetklinika?useUnicode=true&serverTimezone=UTC";
    private static  String user = "root";
    private static final String password = "";

    private static Connection con;
    private static Statement stmt;
    static ResultSet rs;
   @Override
    public void start(Stage stage) throws Exception {
        iniBD();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Vet Klinika");
        stage.setScene(scene);
        stage.show();
        scene.getStylesheets().add((getClass().getResource("/css/style.css")).toExternalForm());
    }
    static void iniBD(){
    

        String query = "select * from animals";

        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
 
       }
   }


    
    
  @Override
    public void stop(){
       try { con.close(); } catch(SQLException se) { }
       try { stmt.close(); } catch(SQLException se) { }
        try { rs.close(); } catch(SQLException se) {  }
    } 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
   }
    
   
    
}
