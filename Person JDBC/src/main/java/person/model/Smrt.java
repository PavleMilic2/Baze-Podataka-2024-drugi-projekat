package person.model;

import java.time.LocalDate;

public class Smrt {

    private int id_smrti;
    private LocalDate datum_smrti;
    private int id_osobe;
    private String uzrok;
    private LocalDate datm_sahrane;

    public Smrt(int id_smrti, LocalDate datum_smrti, int id_osobe, String uzrok, LocalDate datm_sahrane) {
        this.id_smrti = id_smrti;
        this.datum_smrti = datum_smrti;
        this.id_osobe = id_osobe;
        this.uzrok = uzrok;
        this.datm_sahrane = datm_sahrane;
    }

    public int getId_smrti() {
        return id_smrti;
    }

    public void setId_smrti(int id_smrti) {
        this.id_smrti = id_smrti;
    }

    public LocalDate getDatum_smrti() {
        return datum_smrti;
    }

    public void setDatum_smrti(LocalDate datum_smrti) {
        this.datum_smrti = datum_smrti;
    }

    public int getId_osobe() {
        return id_osobe;
    }

    public void setId_osobe(int id_osobe) {
        this.id_osobe = id_osobe;
    }

    public String getUzrok() {
        return uzrok;
    }

    public void setUzrok(String uzrok) {
        this.uzrok = uzrok;
    }

    public LocalDate getDatm_sahrane() {
        return datm_sahrane;
    }

    public void setDatm_sahrane(LocalDate datm_sahrane) {
        this.datm_sahrane = datm_sahrane;
    }
}
