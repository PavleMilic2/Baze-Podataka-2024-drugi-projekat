package person.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import person.model.Person;
import person.model.base.Server;
import person.model.utility.JDBCUtils;

import java.time.LocalDate;
import java.util.List;

public class KupiPrevozControl implements EventHandler<ActionEvent> {

    private final DatePicker dolazak;
    private final DatePicker odlazak;
    private final TextField id_objekta;
    private final ComboBox<String> prevoz;
    private final int id_osobe;

    public KupiPrevozControl(DatePicker dolazak, DatePicker odlazak, ComboBox<String> prevoz, TextField id_objekta, int id_osobe) {
        this.dolazak = dolazak;
        this.odlazak = odlazak;
        this.id_objekta = id_objekta;
        this.prevoz = prevoz;
        this.id_osobe = id_osobe;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        LocalDate vdolaska = this.dolazak.getValue();
        int objekat = Integer.parseInt(id_objekta.getText().trim());
        LocalDate vodlaska = this.odlazak.getValue();
        String psred=this.prevoz.getValue();
        JDBCUtils.addBoravak(vodlaska,vdolaska,psred,this.id_osobe,objekat);
        this.id_objekta.clear();
    }
}
