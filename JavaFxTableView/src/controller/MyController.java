package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Person;

public class MyController implements Initializable {
	
	ObservableList <Person>personen = FXCollections.observableArrayList() ;

    @FXML
    private TableView<Person> tv;

    @FXML
    private TableColumn<Person, String> clVorname;

    @FXML
    private TableColumn<Person, String> clNachname;

    @FXML
    private TextField tfVorname;

    @FXML
    private TextField tfNachname;

    @FXML
    void personEntfernen(ActionEvent event) {
    	String vorname = tfVorname.getText();
    	String nachname = tfNachname.getText();
    	Person p = new Person();
    	p.setVorname(vorname);
    	p.setNachname(nachname);
    	if (personen.contains(p)) {
    			personen.remove(p);
    	}
    }

    @FXML
    void personHinzufuegen(ActionEvent event) {
    	String vorname = tfVorname.getText();
    	String nachname = tfNachname.getText();
    	Person p = new Person();
    	p.setVorname(vorname);
    	p.setNachname(nachname);
    	if (!personen.contains(p))  {
    			personen.add(p);
    	}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//es muss erst in Controller das TableView <?> paramitrisiert -> TableView<Person>
		//damit die Observable Variable "perosnen" von Classe Person funktionfähig wird.
		tv.setItems(personen);
		
		clVorname.setCellValueFactory( new PropertyValueFactory <Person ,String>("vorname"));
		clNachname.setCellValueFactory ( new PropertyValueFactory <Person , String>("nachname"));
		
		
		
	}

}