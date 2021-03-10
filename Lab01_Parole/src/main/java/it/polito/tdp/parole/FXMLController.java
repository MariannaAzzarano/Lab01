package it.polito.tdp.parole;

import it.polito.tdp.parole.model.ComparatoreParole;
import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;
    
    @FXML
    private TextField txtTempo;

    @FXML           //DA FARE CONTEGGIO ns
    void doInsert(ActionEvent event) {
    	String nuova_parola = txtParola.getText();        //prendo la parola
    	elenco.addParola(nuova_parola);                   //inserisco la parola nell'elenco
    	String stringa = "";                              //inizializzo l'elenco
    	for(String s : elenco.getElenco()) {              //creo un'elenco in forma stringa
    		stringa += s +"\n"; 
    	}
    	txtResult.setText(stringa);                       //aggiungo la parola (da capo tutto l'elenco)
    	txtParola.setText("");                            //svuoto la casella di testo dopo aver aggiunto la parola
    	long ns = System.nanoTime();
    	txtTempo.setText(""+ns);
    	
    }

    @FXML               //DA FARE CONTEGGIO ns
    void doReset(ActionEvent event) {
    	txtResult.setText("");                           //faccio scomparire le parole dall'area di testo
    	elenco.reset();                                  //svuoto l'elenco
    	long ns = System.nanoTime();
    	txtTempo.setText(""+ns);
    }
    
    @FXML              //DA FARE CONTEGGIO ns
    void doCancella(ActionEvent event) {
    	elenco.cancella(txtResult.getSelectedText());    //elimino dall'elenco la parola che ho selezionato
    	String stringa = "";                              //inizializzo l'elenco
    	for(String s : elenco.getElenco()) {              //creo un'elenco in forma stringa
    		stringa += s +"\n"; 
    	}
    	txtResult.setText(stringa);                       //aggiungo la parola (da capo tutto l'elenco)
    	long ns = System.nanoTime();
    	txtTempo.setText(""+ns);

    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}
