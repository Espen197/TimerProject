package prototype;

//Import JavaFX Stuff
import javafx.application.Application;
//import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
//import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Main extends Application{
	
	//JavaFX Variables
	private Stage window;
	private Button reset;
	private Scene scene;
	private Label scramble, time, average, times, timeNum;	
	
	//Timer object
	Timing timer = new Timing();
	//Stats object
	Stats stats = new Stats();
	//Scramble object
	Scramble scrambleobj = new Scramble();
	//Alertbox object
	AlertBox resetalert = new AlertBox();
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		//Adding primary window
		window = primaryStage;
		
		//Layout 1 - children are laid out in vertical column
		VBox layout = new VBox(20);	
		scene = new Scene(layout, 375, 667);
		
		
		//Adding buttons
		reset = new Button("Reset");
		
		//Adding Labels
		scramble = new Label(scrambleobj.generateScramble());
		time = new Label("Start Timer");
		average = new Label("Session avg: DNF");
		times = new Label("Times:");
		timeNum = new Label("Number of times: 0");
		
		
		//Adding KeyListeners
				scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
		            @Override
		            public void handle(KeyEvent event) {
		                if(event.getCode() == KeyCode.SPACE){
		                	if(! timer.getRunning() && timer.shouldStart()){
		            			timer.startTime();
		            			time.setText("running");
		            		}
		                }
		            }
		        });
				
				
				scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
		            @Override
		            public void handle(KeyEvent event) {
		                if(event.getCode() == KeyCode.SPACE){
		                	if(timer.getRunning()){
		            			timer.stopTime();
		            			time.setText(timer.getTime());
		            			scramble.setText(scrambleobj.generateScramble());
		            			updateStats();
		            		}
		                }
		                else if((event.getCode() == KeyCode.DELETE) && event.isShiftDown()){
		                	if(resetalert.resetBox()){
		                		resetAction();
		        			}
		        			layout.requestFocus();
		                }
		            }
		        });
				
		
		//Reset-button logic
		reset.setOnAction(e -> {
			if(resetalert.resetBox()){
				this.resetAction();
			}
			layout.requestFocus();
		});
		
		
		
		layout.getChildren().addAll(scramble, time, timeNum, times, average, reset);
		window.setScene(scene);
		window.setTitle("Timer test");
		layout.requestFocus();
		window.show();
	}
	
	public void resetAction(){
		stats.resetStats();
		updateStats();
		time.setText("Start Timer");
	}
	
	public void updateStats(){
		times.setText("Times: " + stats.getTimes());
		average.setText("Session Avg: " + stats.getAverage());
		timeNum.setText("Number of times: 0");
	}
	

}

