package person.model;

import java.time.LocalDate;

public class Osobe {

    private int id_osobe;
    private String ime;
    private String prezime;
    private LocalDate datum_rodjenja;
    private String korisnicko_ime;
    private String lozinka;
    private int id_stambenog_objekta;

    public Osobe(int id_osobe, String ime, String prezime, LocalDate datum_rodjenja, String korisnicko_ime, String lozinka, int id_stambenog_objekta) {
        this.id_osobe = id_osobe;
        this.ime = ime;
        this.prezime = prezime;
        this.datum_rodjenja = datum_rodjenja;
        this.korisnicko_ime = korisnicko_ime;
        this.lozinka = lozinka;
        this.id_stambenog_objekta = id_stambenog_objekta;
    }

    public int getId_osobe() {
        return id_osobe;
    }

    public void setId_osobe(int id_osobe) {
        this.id_osobe = id_osobe;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public LocalDate getDatum_rodjenja() {
        return datum_rodjenja;
    }

    public void setDatum_rodjenja(LocalDate datum_rodjenja) {
        this.datum_rodjenja = datum_rodjenja;
    }

    public String getKorisnicko_ime() {
        return korisnicko_ime;
    }

    public void setKorisnicko_ime(String korisnicko_ime) {
        this.korisnicko_ime = korisnicko_ime;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public int getId_stambenog_objekta() {
        return id_stambenog_objekta;
    }

    public void setId_stambenog_objekta(int id_stambenog_objekta) {
        this.id_stambenog_objekta = id_stambenog_objekta;
    }
}
