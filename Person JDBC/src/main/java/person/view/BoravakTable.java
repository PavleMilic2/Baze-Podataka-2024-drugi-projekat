package person.view;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import person.model.Boravak;

import java.time.LocalDate;
import java.util.List;

public class BoravakTable extends TableView<Boravak> {

    public BoravakTable(List<Boravak> values) {
        super(FXCollections.observableArrayList(values));

        TableColumn<Boravak, Integer> tcIdBoravka = new TableColumn<>("ID Boravka");
        TableColumn<Boravak, LocalDate> tcDatumDolaska = new TableColumn<>("Datum Dolaska");
        TableColumn<Boravak, LocalDate> tcDatumOdlaska = new TableColumn<>("Datum Odlaska");
        TableColumn<Boravak, String> tcPrevoznoSredstvo = new TableColumn<>("Prevozno Sredstvo");
        TableColumn<Boravak, Integer> tcIdOsobe = new TableColumn<>("ID Osobe");
        TableColumn<Boravak, Integer> tcIdObjekta = new TableColumn<>("ID Objekta");

        tcIdBoravka.setCellValueFactory(new PropertyValueFactory<>("id_boravka"));
        tcDatumDolaska.setCellValueFactory(new PropertyValueFactory<>("datum_dolaska"));
        tcDatumOdlaska.setCellValueFactory(new PropertyValueFactory<>("datum_odlaska"));
        tcPrevoznoSredstvo.setCellValueFactory(new PropertyValueFactory<>("prevozno_sredstvo"));
        tcIdOsobe.setCellValueFactory(new PropertyValueFactory<>("id_osobe"));
        tcIdObjekta.setCellValueFactory(new PropertyValueFactory<>("id_objekta"));

        getColumns().addAll(tcIdBoravka, tcDatumDolaska, tcDatumOdlaska, tcPrevoznoSredstvo, tcIdOsobe, tcIdObjekta);
    }
}
