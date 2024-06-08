package person.model.base;

import person.model.*;
import person.model.utility.JDBCUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Server {

    public static final Server SERVER = new Server();

    private final List<Person> people = new ArrayList<>();
    private List<Atmosfera> atmosfere= new ArrayList<>();
    private List<Boravak> boravci=new ArrayList<>();
    private List<Misije> misije= new ArrayList<>();
    private List<Objekti> objekti=new ArrayList<>();
    private List<Osobe> osobe= new ArrayList<>();
    private List<Poznati_Objekti> poznati_objekti=new ArrayList<>();
    private List<Smrt> smrti= new ArrayList<>();
    private List<Stambeni_Objekat> stambeni_objekti=new ArrayList<>();

    private Osobe trenutn_korisnik;

    private Server() {
        this.setPeople(JDBCUtils.selectAllFromPerson());
        this.setAtmosfere(JDBCUtils.selectAllFromAtmosfera());
        JDBCUtils.uradi();
        this.setObjekti(JDBCUtils.selectAllFromObjekti());
        this.setOsobe(JDBCUtils.selectAllFromOsobe());
        this.setBoravci(JDBCUtils.selectAllFromBoravci());
    }

    public Osobe getTrenutn_korisnik() {
        return trenutn_korisnik;
    }

    public void setTrenutn_korisnik(Osobe trenutn_korisnik) {
        this.trenutn_korisnik = trenutn_korisnik;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(Collection<Person> people) {
        this.people.clear();
        this.people.addAll(people);
    }

    public List<Atmosfera> getAtmosfere() {
        return atmosfere;
    }

    public void setAtmosfere(Collection<Atmosfera> atmosfere) {
        this.atmosfere.clear();
        this.atmosfere.addAll(atmosfere);
    }

    public List<Boravak> getBoravci() {
        return boravci;
    }

    public void setBoravci(List<Boravak> boravci) {
        this.boravci = boravci;
    }

    public List<Misije> getMisije() {
        return misije;
    }

    public void setMisije(List<Misije> misije) {
        this.misije = misije;
    }

    public List<Objekti> getObjekti() {
        return objekti;
    }

    public void setObjekti(List<Objekti> objekti) {
        this.objekti = objekti;
    }

    public List<Osobe> getOsobe() {
        return osobe;
    }

    public void setOsobe(List<Osobe> osobe) {
        this.osobe = osobe;
    }

    public List<Poznati_Objekti> getPoznati_objekti() {
        return poznati_objekti;
    }

    public void setPoznati_objekti(List<Poznati_Objekti> poznati_objekti) {
        this.poznati_objekti = poznati_objekti;
    }

    public List<Smrt> getSmrti() {
        return smrti;
    }

    public void setSmrti(List<Smrt> smrti) {
        this.smrti = smrti;
    }

    public List<Stambeni_Objekat> getStambeni_objekti() {
        return stambeni_objekti;
    }

    public void setStambeni_objekti(List<Stambeni_Objekat> stambeni_objekti) {
        this.stambeni_objekti = stambeni_objekti;
    }
}
