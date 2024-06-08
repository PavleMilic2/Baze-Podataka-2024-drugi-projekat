package person.model.utility;

import person.model.*;
import person.model.base.Server;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JDBCUtils {

    public static Connection connection = null;

    public static void connect() {
        Properties properties = new Properties();
        properties.put("user", "root");
        properties.put("password", "");
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/udruzenje_zus", properties);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //region Person
    public static List<Person> selectAllFromPerson() {
        List<Person> people = new ArrayList<>();
        String query = "select * from person";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int personId = resultSet.getInt(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                LocalDate dateOfBirth = resultSet.getDate(4).toLocalDate();
                Person person = new Person(personId, firstName, lastName, dateOfBirth);
                people.add(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return people;
    }

    public static List<Person> selectFromPerson(String firstName, String lastName, String yearOfBirth) {
        List<Person> oldPeople = selectAllFromPerson();
        Server.SERVER.setPeople(oldPeople);
        List<Person> people = new ArrayList<>();
        for (Person oldPerson : oldPeople) {
            if (yearOfBirth == null || yearOfBirth.length() != 4) {
                if (oldPerson.getFirstName().toLowerCase().contains(firstName.toLowerCase())
                        && oldPerson.getLastName().toLowerCase().contains(lastName.toLowerCase()))
                    people.add(oldPerson);
                continue;
            }
            if (oldPerson.getFirstName().toLowerCase().contains(firstName.toLowerCase())
                    && oldPerson.getLastName().toLowerCase().contains(lastName.toLowerCase())
                    && oldPerson.getDateOfBirth().getYear() == Integer.parseInt(yearOfBirth))
                people.add(oldPerson);
        }
        return people;
    }

    public static void insertIntoPerson(String firstName, String lastName, LocalDate dateOfBirth) {
        String query = "insert into person (first_name, last_name, date_of_birth)" +
                "values (?, ?, str_to_date(?, '%m/%d/%Y'))";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3,
                    dateOfBirth.getMonthValue() + "/" +
                            dateOfBirth.getDayOfMonth() + "/" + dateOfBirth.getYear());
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //endregion
    //region Atmosfera
    public static List<Atmosfera> selectAllFromAtmosfera() {
        List<Atmosfera> atmosfere = new ArrayList<>();
        String query = "select * from atmosfera";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id_atmosfere = resultSet.getInt(1);
                int procenat_kiseonika = resultSet.getInt(2);
                int procenat_otrovnog_gasa = resultSet.getInt(3);
                int procenat_neotrovnog_gasa = resultSet.getInt(4);
                int id_objekta = resultSet.getInt(5);
                Atmosfera atmosfera = new Atmosfera(id_atmosfere, procenat_kiseonika, procenat_otrovnog_gasa, procenat_neotrovnog_gasa, id_objekta);
                atmosfere.add(atmosfera);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return atmosfere;
    }

    public static List<Atmosfera> selectFromAtmosfera(String kis, String otrov, String neotrov, String idob) {

        List<Atmosfera> atmosfere = new ArrayList<>();
        String query = "select * from atmosfera where procenat_kiseonika like \'%" + kis + "%\' and procenat_otrovnog_gasa like \'%" + otrov + "%\' and procenat_neotrovnog_gasa like \'%" + neotrov + "%\' and id_objekta=" + idob;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id_atmosfere = resultSet.getInt(1);
                int procenat_kiseonika = resultSet.getInt(2);
                int procenat_otrovnog_gasa = resultSet.getInt(3);
                int procenat_neotrovnog_gasa = resultSet.getInt(4);
                int id_objekta = resultSet.getInt(5);
                Atmosfera atmosfera = new Atmosfera(id_atmosfere, procenat_kiseonika, procenat_otrovnog_gasa, procenat_neotrovnog_gasa, id_objekta);
                atmosfere.add(atmosfera);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return atmosfere;
    }

    //endregion
    //region Osobe
    public static List<Osobe> selectAllFromOsobe() {
        List<Osobe> osobe = new ArrayList<>();
        String query = "select * from osobe";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id_osobe = resultSet.getInt(1);
                String ime = resultSet.getString(2);
                String prezime = resultSet.getString(3);
                LocalDate datum_rodjenja = resultSet.getDate(4).toLocalDate();
                String korisnicko_ime = resultSet.getString(5);
                String lozinka = resultSet.getString(6);
                int id_stambenog_objekta = resultSet.getInt(7);
                Osobe osoba = new Osobe(id_osobe, ime, prezime, datum_rodjenja, korisnicko_ime, lozinka, id_stambenog_objekta);
                osobe.add(osoba);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return osobe;
    }

    public static Osobe selectFromOsobe(int id_osobe) {

        String query = "select * from osobe where id_osobe=" + id_osobe;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                id_osobe = resultSet.getInt(1);
                String ime = resultSet.getString(2);
                String prezime = resultSet.getString(3);
                LocalDate datum_rodjenja = resultSet.getDate(4).toLocalDate();
                String korisnicko_ime = resultSet.getString(5);
                String lozinka = resultSet.getString(6);
                int id_stambenog_objekta = resultSet.getInt(7);
                Osobe osoba = new Osobe(id_osobe, ime, prezime, datum_rodjenja, korisnicko_ime, lozinka, id_stambenog_objekta);
                return osoba;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static void signUp(String ime, String prezime, LocalDate datum_rodjenja, String username, String lozinka) {
        String query = "insert into osobe (ime, prezime, datum_rodjenja, korisnicko_ime, lozinka, id_stambenog_objekta)" +
                "values (?, ?, str_to_date(?, '%m/%d/%Y'),?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setString(1, ime);
            statement.setString(2, prezime);
            statement.setString(3,
                    datum_rodjenja.getMonthValue() + "/" +
                            datum_rodjenja.getDayOfMonth() + "/" + datum_rodjenja.getYear());
            statement.setString(4, username);
            statement.setString(5, lozinka);
            statement.setNull(6, java.sql.Types.INTEGER);
            statement.executeUpdate();
            connection.commit();
            Server.SERVER.setOsobe(JDBCUtils.selectAllFromOsobe());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int signIn(String username, String lozinka) {
        String query = "SELECT id_osobe FROM osobe WHERE korisnicko_ime=? AND lozinka=?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, lozinka);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("id_osobe");
            } else {
                return 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void Naseli(int id_stambenog_objekta, int id_osobe) {
        String query = "UPDATE osobe SET id_stambenog_objekta = ? WHERE id_osobe = ?";

        try {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id_stambenog_objekta);
            statement.setInt(2, id_osobe);

            statement.executeUpdate();
            connection.commit();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //endregion
    //region Objekti

    public static List<Objekti> selectAllFromObjekti() {
        List<Objekti> objekti = new ArrayList<>();
        String query = "select * from objekti";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id_objekta = resultSet.getInt(1);
                String naziv = resultSet.getString(2);
                int udaljenost_od_zvezde = resultSet.getInt(3);
                int najniza_temp = resultSet.getInt(4);
                int najvisa_temp = resultSet.getInt(5);
                int limit_gravitacionog_polja = resultSet.getInt(6);
                int brzina_orbite = resultSet.getInt(7);
                String nastanjiva = resultSet.getString(8);
                int id_poznatog_objekta = resultSet.getInt(9);
                Objekti objekat = new Objekti(id_objekta, naziv, udaljenost_od_zvezde, najniza_temp, najvisa_temp, limit_gravitacionog_polja, brzina_orbite, nastanjiva, id_poznatog_objekta);
                objekti.add(objekat);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return objekti;
    }

    public static List<Objekti> selectNastanljivi() {
        List<Objekti> objekti = new ArrayList<>();
        String query = "select * from objekti where nastanljiva like \'jeste\'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id_objekta = resultSet.getInt(1);
                String naziv = resultSet.getString(2);
                int udaljenost_od_zvezde = resultSet.getInt(3);
                int najniza_temp = resultSet.getInt(4);
                int najvisa_temp = resultSet.getInt(5);
                int limit_gravitacionog_polja = resultSet.getInt(6);
                int brzina_orbite = resultSet.getInt(7);
                String nastanjiva = resultSet.getString(8);
                int id_poznatog_objekta = resultSet.getInt(9);
                Objekti objekat = new Objekti(id_objekta, naziv, udaljenost_od_zvezde, najniza_temp, najvisa_temp, limit_gravitacionog_polja, brzina_orbite, nastanjiva, id_poznatog_objekta);
                objekti.add(objekat);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return objekti;
    }

    public static ArrayList<Integer> setNastanjivost() {
        ArrayList<Integer> idevi = new ArrayList<>();
        String query = "SELECT * FROM objekti obj join atmosfera atm using (id_objekta) " +
                "where (obj.udaljenost_od_zvezde BETWEEN 100 and 200) and (obj.najniza_zabelezena_temperatura" +
                " BETWEEN 150 and 250) and (obj.najvisa_zabelezena_temperatura BETWEEN 250 and 350) and " +
                "(obj.najvisa_zabelezena_temperatura-obj.najniza_zabelezena_temperatura<120) and " +
                "(atm.procenat_kiseonika between 15 and 25) and (atm.procenat_neotrovnog_gasa+atm.procenat_kiseonika" +
                " between 90 and 99) AND (obj.limit_gravitacionog_polja>999) and (obj.brzina_orbite between 25 and 35)";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id_objekta = resultSet.getInt(1);
                idevi.add(id_objekta);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return idevi;
    }

    public static void uradi() {
        ArrayList<Integer> idevi = setNastanjivost();
        String query = "UPDATE objekti SET nastanljiva = 'jeste' WHERE id_objekta = ?";

        try {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(query);

            for (Integer id : idevi) {
                statement.setInt(1, id);
                statement.executeUpdate();
            }

            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static ArrayList<Misije> vratiMisijeZaObjekat(int id_objekta) {
        ArrayList<Misije> misije = new ArrayList<>();
        String query = "SELECT misije.id_misije, poznati_objekat.prvobitni_naziv,\n" +
                "       misije.id_poznatog_objekta, misije.naziv,\n" +
                "       misije.svemirski_brod, misije.predvidjeno_vreme_putovanja\n" +
                "FROM misije JOIN poznati_objekat ON misije.id_poznatog_objekta = poznati_objekat.id_poznatog_objekta\n" +
                "JOIN objekti ON poznati_objekat.id_poznatog_objekta = objekti.id_poznatog_objekta\n" +
                "WHERE id_objekta =" + id_objekta;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id_misije = resultSet.getInt(1);
                String prvobitni_naziv = resultSet.getString(2);
                int id_poznatog_objekta = resultSet.getInt(3);
                String naziv_misije = resultSet.getString(4);
                String svemirski_brod = resultSet.getString(5);
                int vreme_putovanja = resultSet.getInt(6);
                Misije misija = new Misije(id_misije, naziv_misije, id_poznatog_objekta, svemirski_brod, vreme_putovanja, prvobitni_naziv);
                misije.add(misija);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return misije;
    }

    //endregion
    //region StambeniObjekti

    public static List<Stambeni_Objekat> selectStambeniObjekti(int id_objekta) {
        List<Stambeni_Objekat> sobjekti = new ArrayList<>();
        String query = "select * from stambeni_objekat where id_objekta=" + id_objekta + " and id_osobe is null";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id_sobjekta = resultSet.getInt(1);
                int vrednost = resultSet.getInt(2);
                int kvadratura = resultSet.getInt(3);
                double ocena = resultSet.getDouble(4);
                int id_o = resultSet.getInt(5);
                int id_oso = resultSet.getInt(6);
                Stambeni_Objekat sobjekat = new Stambeni_Objekat(id_sobjekta, vrednost, kvadratura, ocena, id_o, id_oso);
                sobjekti.add(sobjekat);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sobjekti;
    }

    public static List<Stambeni_Objekat> selectAllFromStambeniObjekti(int id_osobe) {
        List<Stambeni_Objekat> sobjekti = new ArrayList<>();
        String query = "select * from stambeni_objekat where id_osobe=" + id_osobe;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id_sobjekta = resultSet.getInt(1);
                int vrednost = resultSet.getInt(2);
                int kvadratura = resultSet.getInt(3);
                double ocena = resultSet.getDouble(4);
                int id_o = resultSet.getInt(5);
                int id_oso = resultSet.getInt(6);
                Stambeni_Objekat sobjekat = new Stambeni_Objekat(id_sobjekta, vrednost, kvadratura, ocena, id_o, id_oso);
                sobjekti.add(sobjekat);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Server.SERVER.setStambeni_objekti(sobjekti);
        return sobjekti;
    }

    public static void updateStambeniObjekat(int id_osobe, int id_stambenog_objekta){

        String query = "update stambeni_objekat set id_osobe=? where id_stambenog_objekta=?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setInt(1, id_osobe);
            statement.setInt(2, id_stambenog_objekta);
            statement.executeUpdate();
            connection.commit();
            Server.SERVER.setOsobe(JDBCUtils.selectAllFromOsobe());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //endregion
    //region Boravak
    public static List<Boravak> selectAllFromBoravci() {
        List<Boravak> boravci = new ArrayList<>();
        String query = "select * from boravak";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id_boravka = resultSet.getInt(1);
                LocalDate datum_polaska = resultSet.getDate(2).toLocalDate();
                LocalDate datum_odlaska = resultSet.getDate(3).toLocalDate();
                String prevoz = resultSet.getString(4);
                int id_osobe = resultSet.getInt(5);
                int id_objekta = resultSet.getInt(6);
                Boravak boravak = new Boravak(id_boravka, datum_polaska, datum_odlaska, id_osobe, id_objekta, prevoz);
                boravci.add(boravak);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return boravci;
    }

    public static void addBoravak(LocalDate datum_polaska,LocalDate datum_odlaska,String prevoz,int id_osobe,int id_objekta){

        String query = "insert into boravak (id_boravka, datum_dolaska, datum_odlaska, prevozno_sredstvo, id_osobe, id_objekta)" +
                "values (?, str_to_date(?, '%m/%d/%Y'), str_to_date(?, '%m/%d/%Y'),?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setNull(1, java.sql.Types.INTEGER);
            statement.setString(2,
                    datum_polaska.getMonthValue() + "/" +
                            datum_polaska.getDayOfMonth() + "/" + datum_polaska.getYear());
            statement.setString(3,
                    datum_odlaska.getMonthValue() + "/" +
                            datum_odlaska.getDayOfMonth() + "/" + datum_odlaska.getYear());
            statement.setString(4, prevoz);
            statement.setInt(5, id_osobe);
            statement.setInt(6, id_objekta);
            statement.executeUpdate();
            connection.commit();
            Server.SERVER.setBoravci(JDBCUtils.selectAllFromBoravci());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static List<Boravak> selectAllFromBoravciZaIdKor(int id_osobe) {
        List<Boravak> boravci = new ArrayList<>();
        String query = "select * from boravak where id_osobe="+id_osobe;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id_boravka = resultSet.getInt(1);
                LocalDate datum_polaska = resultSet.getDate(2).toLocalDate();
                LocalDate datum_odlaska = resultSet.getDate(3).toLocalDate();
                String prevoz = resultSet.getString(4);
                int id_os = resultSet.getInt(5);
                int id_objekta = resultSet.getInt(6);
                Boravak boravak = new Boravak(id_boravka, datum_polaska, datum_odlaska, id_os, id_objekta, prevoz);
                boravci.add(boravak);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Server.SERVER.setBoravci(boravci);
        return boravci;
    }

    //endregion
    private JDBCUtils() {

    }

}
