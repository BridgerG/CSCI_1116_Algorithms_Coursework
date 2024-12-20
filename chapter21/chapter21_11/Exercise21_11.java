package chapter21_11;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise21_11 extends Application {
  private Map<String, Integer>[] mapForBoy = new HashMap[10];
  private Map<String, Integer>[] mapForGirl = new HashMap[10];
  
  private Button btFindRanking = new Button("Find Ranking");
  private ComboBox<Integer> cboYear = new ComboBox<>();
  private ComboBox<String> cboGender = new ComboBox<>();
  private TextField tfName = new TextField();
  private Label lblResult = new Label();
  
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    GridPane gridPane = new GridPane();
    gridPane.add(new Label("Select a year:"), 0, 0);
    gridPane.add(new Label("Boy or girl?"), 0, 1);
    gridPane.add(new Label("Enter a name:"), 0, 2);
    gridPane.add(cboYear, 1, 0);
    gridPane.add(cboGender, 1, 1);
    gridPane.add(tfName, 1, 2);
    gridPane.add(btFindRanking, 1, 3);
    gridPane.setAlignment(Pos.CENTER);
    gridPane.setHgap(5);
    gridPane.setVgap(5);
  
    BorderPane borderPane = new BorderPane();
    borderPane.setCenter(gridPane);
    borderPane.setBottom(lblResult);
    BorderPane.setAlignment(lblResult, Pos.CENTER);

    // Create a scene and place it in the stage
    Scene scene = new Scene(borderPane, 370, 160);
    primaryStage.setTitle("Exercise21_11"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage

    for (int year = 2001; year <= 2010; year++) {
      cboYear.getItems().add(year);
      
      mapForBoy[year - 2001] = new HashMap<String, Integer>();
      mapForGirl[year - 2001] = new HashMap<String, Integer>();
		
      try {
  		
  		URL url = new URL("https://liveexample.pearsoncmg.com/data/babynamesranking" + Integer.toString(year) + ".txt");
  		Scanner scan = new Scanner(url.openStream());
  		int iF = 0, iM = 0;

  		while (scan.hasNext()) {
  			
  			iF++;
  			iM++;
  			
  			scan.next();
  			mapForBoy[year - 2001].put(scan.next().toLowerCase(), iM);
  			scan.nextInt();
  			mapForGirl[year - 2001].put(scan.next().toLowerCase(), iF);
  			scan.nextInt();
  		
  		}
  		
      } catch (IOException e) {
  		// TODO Auto-generated catch block
  		e.printStackTrace();
      }
    }
    cboYear.setValue(2001);
    
        
    cboGender.getItems().addAll("Male", "Female");
    cboGender.setValue("Male");
    
    
    btFindRanking.setOnAction(e -> {
    	
    	int selectedYear = cboYear.getValue() - 2001;
		
    	if (cboGender.getValue() == "Male") {
    		
    		if (mapForBoy[selectedYear].containsKey(tfName.getText().toLowerCase()) == true) {
    			
    			lblResult.setText("Boy named " + tfName.getText() + " is ranked #" + mapForBoy[selectedYear].get(tfName.getText().toLowerCase()) + " in the year " + cboYear.getValue());
    			
    		} else {
    			
    			lblResult.setText("This name was not in the top 1000 names of that year.");
    			
    		}
    		
    	} else if (cboGender.getValue() == "Female") {
    		
    		if (mapForGirl[selectedYear].containsKey(tfName.getText().toLowerCase()) == true) {
    			
    			lblResult.setText("Girl named " + tfName.getText() + " is ranked #" + mapForGirl[selectedYear].get(tfName.getText().toLowerCase()) + " in the year " + cboYear.getValue());
    			
    		} else {
    			
    			lblResult.setText("This name was not in the top 1000 names of that year.");
    			
    		}
    		
    	}
		
    });
    

  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
