import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


public class JavaFXTemplate extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Welcome to JavaFX");
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 700,700);
		//scene1 buttons
		Button turnon = new Button();
		Button turnoff = new Button();
		Button port1 = new Button();
		Button port2 = new Button();
		Button port3 = new Button();
		Button port4 = new Button();
		Button begin = new Button();
		Label label = new Label();
		Text IPAddy = new Text();
		//scene2 buttons
		Label serverstats = new Label();
		Label numofclients = new Label();
		Label totalwin = new Label();
		Label clientjoin = new Label();
		Label clientdisconnect = new Label();
		Label client1 = new Label();
		Label client1details = new Label();
		Label client2 = new Label();
		Label client2details = new Label();
		Label client3 = new Label();
		Label client3details = new Label();
		Label client4 = new Label();
		Label client4details = new Label();
		//scene 1 button declarations
		IPAddy.setText("CHOOSE STATE OF SERVER");
		turnon.setText("TURN ON");
		turnoff.setText("TURN OFF");
		label.setText("CHOOSE PORT TO LISTEN TO");
		port1.setText("P1");
		port2.setText("P2");
		port3.setText("P3");
		port4.setText("P4");
		begin.setText("Click to Proceed" + "\n" +" to Listen");
		//scene2 label declarations
		serverstats.setText("SERVER STATS");
		numofclients.setText("# of Clients on:");
		totalwin.setText("TOTAL WINNINGS ACROSS ALL CLIENTS");
		clientdisconnect.setText("");
		clientjoin.setText("");
		client1.setText("Client1:");
		client2.setText("Client2:");
		client3.setText("Client3:");
		client4.setText("Client4:");
		client1details.setText("");
		client2details.setText("");
		client3details.setText("");
		client4details.setText("");
		HBox serverstatus = new HBox(20,serverstats,numofclients,clientdisconnect,clientjoin);
		HBox cleintstatus = new HBox(20, client1details,client1,client2details,client2,client3details,client3,client4details,client4);
		primaryStage.setScene(scene);
		primaryStage.show();
		
				
		
	}

}
