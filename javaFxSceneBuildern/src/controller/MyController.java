package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Beschwerde;

public class MyController implements Initializable {
	
	static List <Beschwerde> beschwerdeListe = new ArrayList <> () ;

    @FXML
    private TextField tfEmail;

    @FXML
    private ComboBox<String> cbAnliegen;

    @FXML
    private TextArea taNachricht;

    @FXML
    private Button fxNachricht;

    @FXML
    void butNachrichtAbschicken(ActionEvent event) {
    	String pattern ="[\\w\\.?]{2,}\\@\\w{2,}\\.[\\a-zA-Z]{2,3}";
    	if (! tfEmail.getText().matches(pattern)) {
    		tfEmail.setText("Bitte nur gültige Email-Adressen eingeben! ");
    	}
    	else {
    		Beschwerde b = new Beschwerde();
    		b.setEmail(tfEmail.getText());
    		b.setAnliegen(cbAnliegen.getValue());
    		if (beschwerdeListe.contains(b))
    			tfEmail.setText("Beschwerde bereits regestriert!");
    		else
    		beschwerdeListe.add(b);    		
    	}
    	beschwerdeListe.forEach((b) -> System.out.println(b));
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
    	cbAnliegen.getItems().addAll("Es schmeckt nicht","Zu lauf","Unfähiges Personal", "Sonstiges");
		
	}

}
