package person.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import person.model.Osobe;
import person.model.Person;
import person.model.base.Server;
import person.model.utility.JDBCUtils;

import java.time.LocalDate;
import java.util.List;

public class SignUpControl implements EventHandler<ActionEvent> {

    private final TextField tfime;
    private final TextField tfprezime;
    private final TextField tfusername;
    private final TextField tflozinka;
    private final DatePicker dp;
    private Label tekst;

    public SignUpControl(TextField tfime, TextField tfprezime, TextField tfusername, TextField tflozinka, DatePicker dp,Label tekst) {
        this.tfime = tfime;
        this.tfprezime = tfprezime;
        this.tfusername = tfusername;
        this.tflozinka = tflozinka;
        this.dp=dp;
        this.tekst=tekst;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        tekst.setText("Uspesan signUp");
        String ime=this.tfime.getText().trim();
        String prezime=this.tfprezime.getText().trim();
        String username=this.tfusername.getText().trim();
        String lozinka=this.tflozinka.getText().trim();
        LocalDate date=this.dp.getValue();
        JDBCUtils.signUp(ime, prezime,date, username,lozinka);
        List<Osobe> osobe = JDBCUtils.selectAllFromOsobe();
        Server.SERVER.setOsobe(osobe);

    }
}
