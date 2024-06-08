package person.view;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import person.model.Objekti;

import java.util.List;

public class ObjektiTable extends TableView<Objekti> {
    public ObjektiTable(List<Objekti> values) {
        super(FXCollections.observableArrayList(values));

        TableColumn<Objekti, Integer> tcIdO = new TableColumn<>("ID");
        TableColumn<Objekti, String> tcNaziv = new TableColumn<>("Naziv");
        TableColumn<Objekti, Integer> tcUda = new TableColumn<>("udaljenost od zvezde");
        TableColumn<Objekti, Integer> tcNajn = new TableColumn<>("najniza temperatura");
        TableColumn<Objekti, Integer> tcNajv = new TableColumn<>("najvisa temperatura");
        TableColumn<Objekti, Integer> tcLim = new TableColumn<>("limit gravitacije");
        TableColumn<Objekti, Integer> tcBrz = new TableColumn<>("Brzina orbite");
        TableColumn<Objekti, String> tcNas = new TableColumn<>("Nastanjivost");
        TableColumn<Objekti, Integer> tcIdPO = new TableColumn<>("ID poznatog objekta");

        tcIdO.setCellValueFactory(new PropertyValueFactory<>("id_objekta"));
        tcNaziv.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        tcUda.setCellValueFactory(new PropertyValueFactory<>("udaljenost_od_zvezde"));
        tcNajn.setCellValueFactory(new PropertyValueFactory<>("najniza_zabelezena_temperatura"));
        tcNajv.setCellValueFactory(new PropertyValueFactory<>("najvisa_zabelezena_temperatura"));
        tcLim.setCellValueFactory(new PropertyValueFactory<>("limit_gravitacionog_polja"));
        tcBrz.setCellValueFactory(new PropertyValueFactory<>("brzina_orbite"));
        tcNas.setCellValueFactory(new PropertyValueFactory<>("nastanljiva"));
        tcIdPO.setCellValueFactory(new PropertyValueFactory<>("id_poznatog_objekta"));

        super.getColumns().add(tcIdO);
        super.getColumns().add(tcNaziv);
        super.getColumns().add(tcUda);
        super.getColumns().add(tcNajn);
        super.getColumns().add(tcNajv);
        super.getColumns().add(tcLim);
        super.getColumns().add(tcBrz);
        super.getColumns().add(tcNas);
        super.getColumns().add(tcIdPO);
    }
}
