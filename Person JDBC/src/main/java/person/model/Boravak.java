package person.model;

import java.time.LocalDate;

public class Boravak {

    private int id_boravka;
    private LocalDate datum_dolaska;
    private LocalDate datum_odlaska;
    private String prevozno_sredstvo;
    private int id_osobe;
    private int id_objekta;

    public Boravak(int id_boravka, LocalDate datum_dolaska, LocalDate datum_odlaska, int id_osobe, int id_objekta, String prevozno_sredstvo) {
        this.id_boravka=id_boravka;
        this.datum_dolaska = datum_dolaska;
        this.datum_odlaska = datum_odlaska;
        this.id_osobe = id_osobe;
        this.id_objekta = id_objekta;
        this.prevozno_sredstvo=prevozno_sredstvo;
    }

    public String getPrevozno_sredstvo() {
        return prevozno_sredstvo;
    }

    public void setPrevozno_sredstvo(String prevozno_sredstvo) {
        this.prevozno_sredstvo = prevozno_sredstvo;
    }

    public int getId_boravka() {
        return id_boravka;
    }

    public void setId_boravka(int id_boravka) {
        this.id_boravka = id_boravka;
    }

    public LocalDate getDatum_dolaska() {
        return datum_dolaska;
    }

    public void setDatum_dolaska(LocalDate datum_dolaska) {
        this.datum_dolaska = datum_dolaska;
    }

    public LocalDate getDatum_odlaska() {
        return datum_odlaska;
    }

    public void setDatum_odlaska(LocalDate datum_odlaska) {
        this.datum_odlaska = datum_odlaska;
    }

    public int getId_osobe() {
        return id_osobe;
    }

    public void setId_osobe(int id_osobe) {
        this.id_osobe = id_osobe;
    }

    public int getId_objekta() {
        return id_objekta;
    }

    public void setId_objekta(int id_objekta) {
        this.id_objekta = id_objekta;
    }
}
