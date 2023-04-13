import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.util.ArrayList;


public class JavaFXTemplate extends Application {
	private static ArrayList<ToggleButton> selectNumbers = new ArrayList<>();
	Stage window;
	Scene scene1, scene2, scene3, scene5,currentScene;
	//public static TextArea t2;
	public static Stage stage;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Welcome to JavaFX");
		VBox root = new VBox();
		VBox borderPane = new VBox();
		scene2 = new Scene(borderPane, 600, 600);
		window = primaryStage;
		Scene scene1 = new Scene(root, 200,200);
		//scene1 buttons
		Button turnon = new Button();
		Button turnoff = new Button();
		Button port1 = new Button();
		Button port2 = new Button();
		Button port3 = new Button();
		Button port4 = new Button();
		GridPane num = new GridPane();
		num.setAlignment(Pos.CENTER);
		for (int i = 1; i <= 4; i++) {
			ToggleButton num_select = new ToggleButton(String.valueOf(i));
			num_select.setPrefSize(50, 50);
			selectNumbers.add(num_select);
			num.add(num_select, (i - 1) % 10, (i - 1) / 10);
		}
		Button begin = new Button();
		Label label = new Label();
		Text IPAddy = new Text();
		//scene2 buttons
		Label serverstats = new Label();
		Label numofclients = new Label();
		Label totalwin = new Label();
		Label clientjoin = new Label();
		Label clientdisconnect = new Label();
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
		begin.setOnAction(e -> window.setScene(scene2));
		//scene2 label declarations
		serverstats.setText("SERVER STATS");
		numofclients.setText("# of Clients on:");
		totalwin.setText("TOTAL WINNINGS ACROSS ALL CLIENTS");
		clientdisconnect.setText("");
		clientjoin.setText("");

		final ListView<String> ClientsList = new ListView<>();
		// Add the items to the List
		ArrayList<String> clients = new ArrayList<>();
		clients.add("Client1:");
		clients.add("Client2:");
		clients.add("Client3:");
		clients.add("Client4:");
		ClientsList.getItems().addAll(clients);
		// Set the size of the ListView
		ClientsList.setPrefSize(120, 120);
		// Enable multiple selection
		ClientsList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		ClientsList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> ov,
								final String oldvalue, final String newvalue) {
				System.out.println("New Value: " + newvalue+"\tOld Value: " + oldvalue);
			}
		});
		StackPane rootclients = new StackPane();
		rootclients.getChildren().add(ClientsList);
		//vboxs for scene one
		HBox beginscene = new HBox(20);
		beginscene.setAlignment(Pos.CENTER);
		beginscene.getChildren().addAll(turnon,turnoff);
		HBox label1 = new HBox(20);
		HBox label2 = new HBox(20);
		label1.setAlignment(Pos.CENTER);
		label2.setAlignment(Pos.CENTER);
		label1.getChildren().add(IPAddy);
		label2.getChildren().add(label);
		HBox beginbox = new HBox(100);
		beginbox.setAlignment(Pos.CENTER);
		beginbox.getChildren().add(begin);
		//vbox for scene2
		VBox serverstatus = new VBox();
		serverstatus.getChildren().addAll(serverstats,numofclients,totalwin,clientdisconnect,clientjoin);
		serverstatus.setAlignment(Pos.BASELINE_LEFT);
		HBox cleintstatus = new HBox(10 );
		cleintstatus.setAlignment(Pos.CENTER_RIGHT);
		cleintstatus.getChildren().addAll(rootclients);
		//scene1 get children
		root.getChildren().addAll(label1,beginscene,label2,num,beginbox);
		//scene2 get children
		borderPane.getChildren().addAll(serverstatus,cleintstatus);
		primaryStage.setScene(scene1);
		primaryStage.show();
		
				
		
	}

}
