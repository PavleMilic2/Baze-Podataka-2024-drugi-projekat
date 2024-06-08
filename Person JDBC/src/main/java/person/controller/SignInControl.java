package person.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import person.model.Osobe;
import person.model.base.Server;
import person.model.utility.JDBCUtils;


public class SignInControl implements EventHandler<ActionEvent> {

    private final TextField tfusername;
    private final TextField tflozinka;
    private Label tekst;
    private Stage mainStage;
    private Stage signInStage;
    private  BorderPane root;

    public SignInControl(TextField tfusername, TextField tflozinka, Label tekst, Stage mainStage, Stage signInStage, BorderPane root) {
        this.tfusername = tfusername;
        this.tflozinka = tflozinka;
        this.tekst=tekst;
        this.mainStage=mainStage;
        this.signInStage=signInStage;
        this.root=root;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        String username=this.tfusername.getText().trim();
        String lozinka=this.tflozinka.getText().trim();
        int x=JDBCUtils.signIn(username,lozinka);
        if(x!=0)
        {
            Osobe osoba=JDBCUtils.selectFromOsobe(x);
            Server.SERVER.setTrenutn_korisnik(osoba);
            System.out.println(osoba.getIme());
            mainStage.setScene(new Scene(root));
            signInStage.close();
        }
        else{
            tekst.setText("Losa lozinka/username");
        }

    }
}