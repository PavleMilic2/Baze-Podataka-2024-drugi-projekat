package person.view;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import person.model.Objekti;
import person.model.Osobe;

import java.time.LocalDate;
import java.util.List;

public class OsobeTable extends TableView<Osobe> {
public OsobeTable(List<Osobe> values) {
        super(FXCollections.observableArrayList(values));

        TableColumn<Osobe, Integer> tcIdo = new TableColumn<>("ID osobe");
        TableColumn<Osobe, String> tcIme = new TableColumn<>("Ime");
        TableColumn<Osobe, String> tcPrezime = new TableColumn<>("Prezime");
        TableColumn<Osobe, LocalDate> tcDR = new TableColumn<>("Datum rodjenja");
        TableColumn<Osobe, Integer> tcIdSO = new TableColumn<>("ID stmbenog objekta u kome stanuje");

        tcIdo.setCellValueFactory(new PropertyValueFactory<>("id_osobe"));
        tcIme.setCellValueFactory(new PropertyValueFactory<>("ime"));
        tcPrezime.setCellValueFactory(new PropertyValueFactory<>("prezime"));
        tcDR.setCellValueFactory(new PropertyValueFactory<>("datum_rodjenja"));
        tcIdSO.setCellValueFactory(new PropertyValueFactory<>("id_stambenog_objekta"));

        super.getColumns().add(tcIdo);
        super.getColumns().add(tcIme);
        super.getColumns().add(tcPrezime);
        super.getColumns().add(tcDR);
        super.getColumns().add(tcIdSO);
    }
}
