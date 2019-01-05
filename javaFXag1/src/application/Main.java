package application;

import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Main extends Application {

	static List<Person> personenListe = new ArrayList<>();

	@Override
	public void start(Stage primaryStage) {

		BorderPane root = new BorderPane();
		VBox vall = new VBox();

		// Nachname
		VBox vnm = new VBox();
		Label lnm = new Label("Nachname");
		TextField tfnm = new TextField();
//			vnm.setSpacing(20);
		vnm.setPadding(new Insets(5, 10, 0, 10)); // 0 unten
		vnm.getChildren().addAll(lnm, tfnm);
//			vall.getChildren().addAll(vnm);

		// Vorname
		VBox vvm = new VBox();
		Label lvm = new Label("Vorname");
		TextField tfvm = new TextField();
//			vnm.setSpacing(20);
		vvm.setPadding(new Insets(0, 10, 20, 10)); // 0 oben 20 unten --
		vvm.getChildren().addAll(lvm, tfvm);

		// Button-�bertragen
		Button bue = new Button("�bertragen");

		// �bertragen
		VBox vue = new VBox();
		Label lue = new Label("�bertragen");
		TextField tfue = new TextField();
		vue.setPadding(new Insets(10, 10, 20, 10));
		vue.getChildren().addAll(lue, tfue);

		// �bertragenKlasse-Button
		HBox bbp = new HBox();
		Button buek = new Button("�bertragen Klasse");
		Button bperson = new Button("Alle Personen ausgeben");
		bbp.getChildren().addAll(buek, bperson);

		// Alle Elemente
		vall.getChildren().addAll(vnm, vvm, bue, vue, bbp);
		root.setCenter(vall);

		Scene scene = new Scene(root, 300, 250);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();

		// Event--Handler
		bue.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				tfue.setText(tfnm.getText() + " " + tfvm.getText());

			}

		});

		buek.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				boolean vor = eingabeUeberbr�fen(tfvm.getText());
				boolean nach = eingabeUeberbr�fen(tfnm.getText());

				if (vor && nach) {
					Person p = new Person(tfvm.getText(), tfnm.getText());
					personenListe.add(p);
					System.out.println(p);
				}

				else
				tfue.setText("Bitte nur Buchstaben eingeben");
			}

		});

		bperson.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (personenListe.size()!=0) 
				personenListe.forEach((per) -> System.out.println(per));
			}

		});

	}

	public static void main(String[] args) {
		launch(args);
//System.out.println(eingabeUeberbr�fen ("googel����"));	
	}

	public static boolean eingabeUeberbr�fen(String str1) {
		return str1.matches("[A-Z���a-z����]+");
	}
}
