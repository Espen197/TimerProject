package prototype;

//Import JavaFX Stuff
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {
	
	boolean resetCheck = false;

	
	public boolean resetBox(){
		Stage window = new Stage();
		
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Reset stats");
		window.setMinWidth(250);
		
		Label label = new Label("Do you want to delete all your times");
		Button accept = new Button("Accept");
		Button cancel = new Button("Cancel");
		
		accept.setOnAction(e -> {
			resetCheck = true;
			window.close();
		});
		
		cancel.setOnAction(e -> {
			window.close();
		});
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, accept, cancel);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		return resetCheck;
	}

}
