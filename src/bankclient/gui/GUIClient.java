package bankclient.gui;
 


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
 
public class GUIClient extends Application {
    ClientGUIController clientGUIController;
    TextField userTextField;
    PasswordField pwBox;
    void gogo(){
    	System.out.println("Hier in de GUIclietn");
    	
    }
    void inlogButtonAction(){
    	boolean verbonden = false;
    	try{
    	verbonden = clientGUIController.verbindMetBank(userTextField.getText(), pwBox.getText());
    	}catch(Exception e){
    		
    	}
    	if(verbonden){
    		System.out.println("Yes verbonden vanuit GUIClient");
    	}else{
    		System.out.println("Nope Niet verbonden van GUIClient");
    	}
    	System.out.println("Aan het einde in GUI Client");
    	
    }
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");
        clientGUIController = new ClientGUIController(this);
        Button btn = new Button();
        btn.setText("Inloggen");
        btn.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent event) {
            	inlogButtonAction();
            }
        });
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);
        grid.add(btn, 0, 3);
        Scene scene = new Scene(grid, 1000, 750);
        primaryStage.setScene(scene);
        StackPane root = new StackPane();
        root.getChildren().add(grid);
        primaryStage.setScene(new Scene(root, 1000, 750));
        primaryStage.show();
    }
}