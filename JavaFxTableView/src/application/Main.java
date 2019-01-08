package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.Person;
import model.PersonRepository;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			URL location = Main.class.getResource("ViewTV.fxml");
			Parent root = FXMLLoader.load(location);

			Scene scene = new Scene(root, 400, 400);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		PersonRepository pr = new PersonRepository();
		pr.start();
		PersonRepository.conn=erstelleVerbindung();
//		Thread th1 = new Thread (new Runnable () {
//			List <Person> dbListe;
//			@Override
//			public void run() {
//				while (true) {
//				try {
//					Thread.sleep(5000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				System.out.println("aus Run Method");
//				dbListe= PersonRepository.LeseDb();
//				for (Person p : dbListe) {
//					if (!PersonRepository.getPersonen().contains(p)) {
//						PersonRepository.addToPersonen(p);
//						System.out.println("aus add liste");
//					}
//				}
//				
//				for (Person p :PersonRepository.getPersonen()) {
//					if (!dbListe.contains(p)) {
//						PersonRepository.removeFromPersonen(p);		
//					System.out.println("aus remove liste");
//					}
//				}
//			}
//			}
//		});
//		
//		th1.start();
		System.out.println("Launch wird nun startet!");
		
		launch(args);
		
	}

	private static Connection erstelleVerbindung() {
		String dbname = "jdbc:mysql://localhost:3306/personDB?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String username = "root";
		String password = "";

		Connection con = null;
		try {
			con = DriverManager.getConnection(dbname, username, password);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		System.out.println("Verbindung wurde erstellt!");
		return con;
	}

}
