package person.view;

import com.mysql.cj.protocol.x.XServerCapabilities;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import person.controller.*;
import person.model.*;
import person.model.base.Server;
import person.model.utility.JDBCUtils;

import java.time.LocalDate;
import java.util.MissingFormatArgumentException;

public class MainView extends Stage {

    private final BorderPane root = new BorderPane();
    private final BorderPane signUp = new BorderPane();
    private final BorderPane pocetak = new BorderPane();

    private final TableView<Person> tvPeople = new PersonTable(Server.SERVER.getPeople());
    private final TableView<Atmosfera> tvAtmo = new AtmosferaTable(Server.SERVER.getAtmosfere());
    private final TableView<Objekti> tvObj = new ObjektiTable(Server.SERVER.getObjekti());
    private final TableView<Misije> tvMisije=new MisijeTable(Server.SERVER.getMisije());
    private final TableView<Osobe> tvOsobe=new OsobeTable(Server.SERVER.getOsobe());
    private final TableView<Stambeni_Objekat> tvSObjekat=new SObjektiTable(Server.SERVER.getStambeni_objekti());
    private final TableView<Boravak> tvBoravak=new BoravakTable(Server.SERVER.getBoravci());

    private final TextField tfFirstNameFilter = new TextField();
    private final TextField tfLastNameFilter = new TextField();
    private final TextField tfYearFilter = new TextField();

    private final TextField tfIme = new TextField();
    private final TextField tfPrezime = new TextField();
    private final TextField tfusername = new TextField();
    private final TextField tfLozinka = new TextField();

    private final TextField tfBorObj=new TextField();
    private final Label lbDatumPolaska=new Label("Datum polaska: ");
    private final Label lbDatumOdlaska=new Label("Datum odlaska: ");
    private final Label Id_objekta=new Label("Id_Objekta: ");
    private final Label lbIme = new Label("Ime: ");
    private final Label lbPrezime = new Label("Prezime: ");
    private final Label lbusername = new Label("Username: ");
    private final Label lbLozinka = new Label("Password:");
    private Label lblTeks=new Label("");
    private Label lblPrevoz=new Label("Prevoz: ");
    private final Button btFilter = new Button("Filter");
    private final Button btnSignIn = new Button("Sign In");
    private final Button btnSignUp = new Button("Sign Up");
    private final Button btnPrikaziUsere=new Button("Prikazi Korisnike");
    private final DatePicker dpSignUp = new DatePicker(
            LocalDate.now().plusYears(80));
    private final Button btnSignSignUp=new Button("OK");
    private final Button btnSignSignIn=new Button("OK");
    private final Button btnNazad=new Button("Nazad");
    private final Button btnNazad2=new Button("Nazad");

    private final TextField tfFirstName = new TextField();
    private final TextField tfLastName = new TextField();
    private final DatePicker dpDateOfBirth = new DatePicker(
            LocalDate.now().plusYears(80));
    private final DatePicker dpDatumOdlaska = new DatePicker(
            LocalDate.now().plusYears(100));
    private final DatePicker dpDatumDolaska = new DatePicker(
            LocalDate.now().plusYears(100));
    private final Button btAdd = new Button("Add new person");
    private final Button btnPlanete=new Button("Odabir planete");
    private final Button btnMisije=new Button("Misije za odredjenu planetu");
    private final Button btnPolazak=new Button("Putovanje");
    private final Button btnStan=new Button("Kupovina stambenog objekta");
    private final Button btnVidiStanove=new Button("Vidi Stambene Objekte");
    private final Button btnKupi=new Button("Kupi");
    private final Button btnKupiBoravak=new Button("Kupi Boravak");

    private final Button btnKraj=new Button ("Prikaz svih korisnikovih stambenih objekata i prevoza");

    private final Button btnNaseli=new Button("Naseli objekat");

    /*public MainView() {
        super.setTitle("Udruzenje ZUS");

        this.btFilter.setOnAction(new FilterControl(this.tfFirstNameFilter, this.tfLastNameFilter, this.tfYearFilter, this.tvPeople));
        this.btAdd.setOnAction(new AddControl(this.tfFirstName, this.tfLastName, this.dpDateOfBirth, this.tvPeople));

        this.root.setCenter(this.tvObj);
        this.root.setTop(this.filterBox());
        this.root.setRight(this.addBox());

        super.setScene(new Scene(this.root));
    }*/
    public MainView() {
        super.setTitle("Udruzenje ZUS");

        this.btFilter.setOnAction(new FilterControl(this.tfFirstNameFilter, this.tfLastNameFilter, this.tfYearFilter, this.tvPeople));
        this.btAdd.setOnAction(new AddControl(this.tfFirstName, this.tfLastName, this.dpDateOfBirth, this.tvPeople));

        HBox box = new HBox();
        box.setAlignment(Pos.CENTER);
        box.setSpacing(10);
        box.getChildren().addAll(btnPlanete, btnPolazak,btnStan);
        VBox poc2 = new VBox();
        poc2.setAlignment(Pos.CENTER);
        poc2.setSpacing(10);
        poc2.getChildren().addAll(box,btnKraj);
        this.root.setCenter(poc2);
        this.root.setPrefSize(500, 150);

        btnPlanete.setOnAction(e->planeteWindow());
        btnSignUp.setOnAction(e -> signUpWindow());
        btnPrikaziUsere.setOnAction(e->prikaziUsere());
        btnSignIn.setOnAction(e->signInWindow());
        btnStan.setOnAction(e->planeteKupovinaWindow());
        btnPolazak.setOnAction(e->putovanjeWindow());
        btnKraj.setOnAction(e->krajWindow());

        HBox poc = new HBox();
        poc.setAlignment(Pos.CENTER);
        poc.setSpacing(10);
        poc.getChildren().addAll(btnSignUp, btnSignIn,btnPrikaziUsere);

        pocetak.setCenter(poc);
        pocetak.setPrefSize(300, 150);

        super.setScene(new Scene(this.pocetak));
    }

    private HBox filterBox() {
        HBox hbox = new HBox(10, new Label("First name:"), this.tfFirstNameFilter,
                new Label("Last name:"), this.tfLastNameFilter,
                new Label("Year:"), this.tfYearFilter,
                this.btFilter);
        hbox.setPadding(new Insets(10));
        hbox.setAlignment(Pos.CENTER);
        return hbox;
    }

    private GridPane addBox() {
        GridPane gridPane = new GridPane();
        gridPane.addRow(0, new Label("First name:"), this.tfFirstName);
        gridPane.addRow(1, new Label("Last name:"), this.tfLastName);
        gridPane.addRow(2, new Label("Date of birth:"), this.dpDateOfBirth);
        gridPane.add(this.btAdd, 1, 3);
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10));
        gridPane.setAlignment(Pos.CENTER);
        return gridPane;
    }

    private void signUpWindow() {
        lblTeks.setText("");
        Stage signUpStage = new Stage();
        signUpStage.setTitle("Sign Up");

        btnSignSignUp.setOnAction(new SignUpControl(this.tfIme, this.tfPrezime, this.tfusername, this.tfLozinka,this.dpSignUp,this.lblTeks));
        btnNazad.setOnAction(e -> signUpStage.close());


        VBox in = new VBox();
        HBox HBime=new HBox();
        HBime.setAlignment(Pos.CENTER);
        HBox HBprezime=new HBox();
        HBprezime.setAlignment(Pos.CENTER);
        HBox HBuser=new HBox();
        HBuser.setAlignment(Pos.CENTER);
        HBox HBloz=new HBox();
        HBloz.setAlignment(Pos.CENTER);
        HBox HBdug=new HBox();
        HBdug.setAlignment(Pos.CENTER);
        HBdug.setSpacing(10);
        HBdug.getChildren().addAll(btnSignSignUp,btnNazad);


        HBime.getChildren().addAll(lbIme,tfIme);
        HBprezime.getChildren().addAll(lbPrezime,tfPrezime);
        HBuser.getChildren().addAll(lbusername,tfusername);
        HBloz.getChildren().addAll(lbLozinka,tfLozinka);
        in.setAlignment(Pos.CENTER);
        in.setSpacing(10);
        in.getChildren().addAll(HBime, HBprezime,HBuser,HBloz,dpSignUp,HBdug,lblTeks);
        signUp.setCenter(in);
        signUp.setPrefSize(300, 200);
        signUpStage.setScene(new Scene(signUp));
        signUpStage.show();
    }

    private void prikaziUsere(){
        this.tvOsobe.setItems(FXCollections.observableArrayList(Server.SERVER.getOsobe()));
        Stage korisniciStage = new Stage();
        korisniciStage.setTitle("Korisnici");

        btnNazad.setOnAction(e -> korisniciStage.close());

        VBox box=new VBox();
        box.setAlignment(Pos.CENTER);
        box.setSpacing(10);
        box.getChildren().addAll(tvOsobe,btnNazad);

        korisniciStage.setScene(new Scene(box));
        korisniciStage.show();

    }

    private void signInWindow() {
        lblTeks.setText("");
        tfusername.clear();
        tfLozinka.clear();
        Stage signInStage = new Stage();
        signInStage.setTitle("Sign In");

        btnSignSignIn.setOnAction(new SignInControl(tfusername,tfLozinka,lblTeks,this,signInStage,root));

        VBox box=new VBox();
        HBox HBuser=new HBox();
        HBuser.setAlignment(Pos.CENTER);
        HBox HBloz=new HBox();
        HBloz.setAlignment(Pos.CENTER);
        HBuser.getChildren().addAll(lbusername,tfusername);
        HBloz.getChildren().addAll(lbLozinka,tfLozinka);
        box.getChildren().addAll(HBuser,HBloz,btnSignSignIn,lblTeks);
        box.setAlignment(Pos.CENTER);
        box.setSpacing(10);

        signInStage.setScene(new Scene(box));
        signInStage.show();
    }

    private void planeteWindow(){
        Label buffer=new Label("     ");

        tvObj.getItems().clear();
        tvObj.getItems().addAll(JDBCUtils.selectAllFromObjekti());

        Stage stage = new Stage();
        stage.setTitle("Planete");

        BorderPane bp=new BorderPane();
        bp.setLeft(tvObj);
        bp.setRight(tvAtmo);
        HBox vb=new HBox();
        vb.setSpacing(10);
        vb.getChildren().addAll(btnMisije,btnNazad2);
        vb.setAlignment(Pos.CENTER);
        vb.setPadding(new Insets(20));
        bp.setBottom(vb);
        bp.setCenter(buffer);
        bp.setPadding(new Insets(10));

        btnNazad2.setOnAction(e -> stage.close());

        tvObj.setOnMouseClicked((MouseEvent event) -> {
            Objekti selectedObjekat = tvObj.getSelectionModel().getSelectedItem();
            if (selectedObjekat != null) {
                System.out.println("Selected ID: " + selectedObjekat.getId_objekta());
                Server.SERVER.setMisije(JDBCUtils.vratiMisijeZaObjekat(selectedObjekat.getId_objekta()));
            }
        });

        btnMisije.setOnAction(e->misijeWindow());

        stage.setScene(new Scene(bp));
        stage.show();

    }

    private void misijeWindow(){

        tvMisije.getItems().clear();
        tvMisije.getItems().addAll(Server.SERVER.getMisije());

        Stage stage = new Stage();
        stage.setTitle("Misije");

        VBox vb=new VBox();
        HBox hb=new HBox();
        hb.setAlignment(Pos.CENTER);
        hb.setPadding(new Insets(20));
        hb.setSpacing(20);
        vb.setAlignment(Pos.CENTER);
        vb.setPadding(new Insets(20));
        hb.getChildren().addAll(tvMisije);
        vb.getChildren().addAll(hb,btnNazad);

        btnNazad.setOnAction(e -> stage.close());

        stage.setScene(new Scene(vb));
        stage.show();

    }
    public void planeteKupovinaWindow(){

        tvObj.getItems().clear();
        tvObj.getItems().addAll(JDBCUtils.selectNastanljivi());

        Stage stage = new Stage();
        stage.setTitle("Kupovina");

        VBox vb=new VBox();
        HBox hb=new HBox();
        hb.setAlignment(Pos.CENTER);
        hb.setPadding(new Insets(20));
        hb.setSpacing(20);
        HBox hb2=new HBox();
        hb2.setAlignment(Pos.CENTER);
        hb2.setPadding(new Insets(20));
        hb2.setSpacing(20);
        vb.setAlignment(Pos.CENTER);
        vb.setPadding(new Insets(20));
        hb.getChildren().addAll(tvObj);
        hb2.getChildren().addAll(btnNazad2,btnVidiStanove);
        vb.getChildren().addAll(hb,hb2);

        btnNazad2.setOnAction(e -> stage.close());
        btnVidiStanove.setOnAction(e->sobjektiWindow());

        tvObj.setOnMouseClicked((MouseEvent event) -> {
            Objekti selectedObjekat = tvObj.getSelectionModel().getSelectedItem();
            if (selectedObjekat != null) {
                System.out.println("Selected ID Kupovina: " + selectedObjekat.getId_objekta());
                Server.SERVER.setStambeni_objekti(JDBCUtils.selectStambeniObjekti(selectedObjekat.getId_objekta()));
            }
        });

        stage.setScene(new Scene(vb));
        stage.show();

    }
    public void sobjektiWindow(){

        tvSObjekat.getItems().clear();
        tvSObjekat.getItems().addAll(Server.SERVER.getStambeni_objekti());

        Stage stage = new Stage();
        stage.setTitle("Kupovina");

        HBox hb=new HBox();
        hb.setAlignment(Pos.CENTER);
        hb.setPadding(new Insets(20));
        hb.setSpacing(20);
        hb.getChildren().addAll(btnNazad,btnKupi);

        VBox vb=new VBox();
        vb.setAlignment(Pos.CENTER);
        vb.setPadding(new Insets(20));
        vb.getChildren().addAll(tvSObjekat,hb);

        btnNazad.setOnAction(e -> stage.close());

        tvSObjekat.setOnMouseClicked((MouseEvent event) -> {
            Stambeni_Objekat selectedObjekat = tvSObjekat.getSelectionModel().getSelectedItem();
            if (selectedObjekat != null) {
                System.out.println("Selected ID stambenog objekta Kupovina: " + selectedObjekat.getId_stambenog_objekta());

                btnKupi.setOnAction(e->JDBCUtils.updateStambeniObjekat(Server.SERVER.getTrenutn_korisnik().getId_osobe(),selectedObjekat.getId_stambenog_objekta()));
                Server.SERVER.setStambeni_objekti(JDBCUtils.selectStambeniObjekti(selectedObjekat.getId_objekta()));
            }
        });

        stage.setScene(new Scene(vb));
        stage.show();

    }

    public void  putovanjeWindow(){
        Stage stage = new Stage();
        stage.setTitle("Kupovina prevoza");

        ObservableList<String> prevozi = FXCollections.observableArrayList("USS ENTERPRISE", "MILLENNIUM FALCON", "HIGHLINER", "SPACEX STARSHIP");

        ComboBox<String> prevoz = new ComboBox<>(prevozi);

        prevoz.setValue("USS ENTERPRISE");

        HBox hb1=new HBox();
        hb1.setAlignment(Pos.CENTER);
        hb1.setPadding(new Insets(20));
        hb1.setSpacing(20);
        hb1.getChildren().addAll(lbDatumPolaska,dpDatumDolaska);
        HBox hb2=new HBox();
        hb2.setAlignment(Pos.CENTER);
        hb2.setPadding(new Insets(20));
        hb2.setSpacing(20);
        hb2.getChildren().addAll(lbDatumOdlaska,dpDatumOdlaska);
        HBox hb3=new HBox();
        hb3.setAlignment(Pos.CENTER);
        hb3.setPadding(new Insets(20));
        hb3.setSpacing(20);
        hb3.getChildren().addAll(Id_objekta,tfBorObj);
        HBox hb4=new HBox();
        hb4.setAlignment(Pos.CENTER);
        hb4.setPadding(new Insets(20));
        hb4.setSpacing(20);
        hb4.getChildren().addAll(lblPrevoz,prevoz);
        HBox hb5=new HBox();
        hb5.setAlignment(Pos.CENTER);
        hb5.setPadding(new Insets(20));
        hb5.setSpacing(20);
        hb5.getChildren().addAll(btnNazad,lblTeks,btnKupiBoravak);

        btnNazad.setOnAction(e -> stage.close());
        btnKupiBoravak.setOnAction(new KupiPrevozControl(dpDatumDolaska, dpDatumOdlaska,prevoz, tfBorObj, Server.SERVER.getTrenutn_korisnik().getId_osobe()));

        VBox vb=new VBox();
        vb.setAlignment(Pos.CENTER);
        vb.setPadding(new Insets(20));
        vb.setSpacing(20);
        vb.getChildren().addAll(hb1,hb2,hb3,hb4,hb5);

        vb.setPrefSize(400, 400);

        stage.setScene(new Scene(vb));
        stage.show();
    }

    public void krajWindow(){

        JDBCUtils.selectAllFromStambeniObjekti(Server.SERVER.getTrenutn_korisnik().getId_osobe());
        tvSObjekat.getItems().clear();
        tvSObjekat.getItems().addAll(Server.SERVER.getStambeni_objekti());
        JDBCUtils.selectAllFromBoravciZaIdKor(Server.SERVER.getTrenutn_korisnik().getId_osobe());
        tvBoravak.getItems().clear();
        tvBoravak.getItems().addAll(Server.SERVER.getBoravci());

        Stage stage = new Stage();
        stage.setTitle("Kupovina prevoza");

        HBox hb1=new HBox();
        hb1.setAlignment(Pos.CENTER);
        hb1.setPadding(new Insets(20));
        hb1.setSpacing(20);
        hb1.getChildren().addAll(tvSObjekat,tvBoravak);
        HBox hb2=new HBox();
        hb2.setAlignment(Pos.CENTER);
        hb2.setPadding(new Insets(20));
        hb2.setSpacing(20);
        hb2.getChildren().addAll(btnNaseli,btnNazad);
        VBox vb=new VBox();
        vb.setAlignment(Pos.CENTER);
        vb.setPadding(new Insets(20));
        vb.setSpacing(20);
        vb.getChildren().addAll(hb1,hb2);

        btnNazad.setOnAction(e -> stage.close());

        tvSObjekat.setOnMouseClicked((MouseEvent event) -> {
            Stambeni_Objekat selectedObjekat = tvSObjekat.getSelectionModel().getSelectedItem();
            if (selectedObjekat != null) {
                System.out.println("Selected ID stambenog objekta Naseljavanje: " + selectedObjekat.getId_stambenog_objekta());

                btnNaseli.setOnAction(e->JDBCUtils.Naseli(selectedObjekat.getId_stambenog_objekta(),Server.SERVER.getTrenutn_korisnik().getId_osobe()));
            }
        });

        stage.setScene(new Scene(vb));
        stage.show();
    }
}
