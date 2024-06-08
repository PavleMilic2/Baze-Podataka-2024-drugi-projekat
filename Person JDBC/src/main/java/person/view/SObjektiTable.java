package person.view;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import person.model.Stambeni_Objekat;

import java.util.List;

public class SObjektiTable extends TableView<Stambeni_Objekat> {

    public SObjektiTable(List<Stambeni_Objekat> values) {
        super(FXCollections.observableArrayList(values));

        TableColumn<Stambeni_Objekat, Integer> tcIdStambenogObjekta = new TableColumn<>("ID Stambenog Objekta");
        TableColumn<Stambeni_Objekat, Integer> tcVrednost = new TableColumn<>("Vrednost");
        TableColumn<Stambeni_Objekat, Integer> tcKvadratura = new TableColumn<>("Kvadratura");
        TableColumn<Stambeni_Objekat, Double> tcOcena = new TableColumn<>("Ocena");
        TableColumn<Stambeni_Objekat, Integer> tcIdObjekta = new TableColumn<>("ID Objekta");
        TableColumn<Stambeni_Objekat, Integer> tcIdOsobe = new TableColumn<>("ID Osobe");

        tcIdStambenogObjekta.setCellValueFactory(new PropertyValueFactory<>("id_stambenog_objekta"));
        tcVrednost.setCellValueFactory(new PropertyValueFactory<>("vrednost"));
        tcKvadratura.setCellValueFactory(new PropertyValueFactory<>("kvadratura"));
        tcOcena.setCellValueFactory(new PropertyValueFactory<>("ocena"));
        tcIdObjekta.setCellValueFactory(new PropertyValueFactory<>("id_objekta"));
        tcIdOsobe.setCellValueFactory(new PropertyValueFactory<>("id_osobe"));

        getColumns().addAll(tcIdStambenogObjekta, tcVrednost, tcKvadratura, tcOcena, tcIdObjekta, tcIdOsobe);
    }
}