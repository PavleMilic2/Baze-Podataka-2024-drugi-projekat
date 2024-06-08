package person.view;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import person.model.Atmosfera;
import person.model.Misije;

import java.util.List;

public class MisijeTable extends TableView<Misije> {
    public MisijeTable(List<Misije> values) {
        super(FXCollections.observableArrayList(values));

        TableColumn<Misije, Integer> tcIdM = new TableColumn<>("ID Misije");
        TableColumn<Misije, String> tcNazM = new TableColumn<>("Naziv Misije");
        TableColumn<Misije, String> tcPON = new TableColumn<>("Prvobitni naziv objekta");
        TableColumn<Misije, Integer> tcIdPO = new TableColumn<>("id_poznatog_objekta");
        TableColumn<Misije, String> tcSB = new TableColumn<>("Svemirski brod");
        TableColumn<Misije, Integer> tcPV = new TableColumn<>("Vreme Putovanja");


        tcIdM.setCellValueFactory(new PropertyValueFactory<>("id_misije"));
        tcNazM.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        tcPON.setCellValueFactory(new PropertyValueFactory<>("poznati_objekti_naziv"));
        tcSB.setCellValueFactory(new PropertyValueFactory<>("svemirski_brod"));
        tcIdPO.setCellValueFactory(new PropertyValueFactory<>("id_poznatog_objekta"));
        tcPV.setCellValueFactory(new PropertyValueFactory<>("predvidjeno_vreme_putovanja"));

        super.getColumns().add(tcIdM);
        super.getColumns().add(tcNazM);
        super.getColumns().add(tcPON);
        super.getColumns().add(tcSB);
        super.getColumns().add(tcIdPO);
        super.getColumns().add(tcPV);
    }
}

