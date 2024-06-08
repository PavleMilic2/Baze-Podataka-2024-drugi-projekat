package person.view;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import person.model.Atmosfera;

import java.util.List;

public class AtmosferaTable extends TableView<Atmosfera> {
    public AtmosferaTable(List<Atmosfera> values) {
        super(FXCollections.observableArrayList(values));

        TableColumn<Atmosfera, Integer> tcAid = new TableColumn<>("ID Atmosfere");
        TableColumn<Atmosfera, Integer> tckis = new TableColumn<>("% Kiseonika");
        TableColumn<Atmosfera, Integer> tcotr = new TableColumn<>("% Otrovnog gasa");
        TableColumn<Atmosfera, Integer> tcneotr = new TableColumn<>("% Neotrovnog gasa");
        TableColumn<Atmosfera, Integer> tcObjectId = new TableColumn<>("ID Objekta");


        tcAid.setCellValueFactory(new PropertyValueFactory<>("id_atmosfere"));
        tckis.setCellValueFactory(new PropertyValueFactory<>("procenat_kiseonika"));
        tcotr.setCellValueFactory(new PropertyValueFactory<>("procenat_otrovnog_gasa"));
        tcneotr.setCellValueFactory(new PropertyValueFactory<>("procenat_neotrovnog_gasa"));
        tcObjectId.setCellValueFactory(new PropertyValueFactory<>("id_objekta"));

        super.getColumns().add(tcAid);
        super.getColumns().add(tckis);
        super.getColumns().add(tcotr);
        super.getColumns().add(tcneotr);
        super.getColumns().add(tcObjectId);
    }
}
