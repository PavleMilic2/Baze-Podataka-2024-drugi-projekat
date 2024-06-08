package person.model;

public class Objekti {

    private int id_objekta;
    private String naziv;
    private int udaljenost_od_zvezde;
    private int najniza_zabelezena_temperatura;
    private int najvisa_zabelezena_temperatura;
    private int limit_gravitacionog_polja;
    private int brzina_orbite;
    private String nastanljiva;
    private int id_poznatog_objekta;

    public Objekti(int id_objekta, String naziv, int udaljenost_od_zvezde, int najniza_zabelezena_temperatura, int najvisa_zabelezena_temperatura, int limit_gravitacionog_polja, int brzina_orbite, String nastanljiva, int id_poznatog_objekta) {
        this.id_objekta = id_objekta;
        this.naziv = naziv;
        this.udaljenost_od_zvezde = udaljenost_od_zvezde;
        this.najniza_zabelezena_temperatura = najniza_zabelezena_temperatura;
        this.najvisa_zabelezena_temperatura = najvisa_zabelezena_temperatura;
        this.limit_gravitacionog_polja = limit_gravitacionog_polja;
        this.brzina_orbite = brzina_orbite;
        this.nastanljiva = nastanljiva;
        this.id_poznatog_objekta = id_poznatog_objekta;
    }

    public int getId_objekta() {
        return id_objekta;
    }

    public void setId_objekta(int id_objekta) {
        this.id_objekta = id_objekta;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getUdaljenost_od_zvezde() {
        return udaljenost_od_zvezde;
    }

    public void setUdaljenost_od_zvezde(int udaljenost_od_zvezde) {
        this.udaljenost_od_zvezde = udaljenost_od_zvezde;
    }

    public int getNajniza_zabelezena_temperatura() {
        return najniza_zabelezena_temperatura;
    }

    public void setNajniza_zabelezena_temperatura(int najniza_zabelezena_temperatura) {
        this.najniza_zabelezena_temperatura = najniza_zabelezena_temperatura;
    }

    public int getNajvisa_zabelezena_temperatura() {
        return najvisa_zabelezena_temperatura;
    }

    public void setNajvisa_zabelezena_temperatura(int najvisa_zabelezena_temperatura) {
        this.najvisa_zabelezena_temperatura = najvisa_zabelezena_temperatura;
    }

    public int getLimit_gravitacionog_polja() {
        return limit_gravitacionog_polja;
    }

    public void setLimit_gravitacionog_polja(int limit_gravitacionog_polja) {
        this.limit_gravitacionog_polja = limit_gravitacionog_polja;
    }

    public int getBrzina_orbite() {
        return brzina_orbite;
    }

    public void setBrzina_orbite(int brzina_orbite) {
        this.brzina_orbite = brzina_orbite;
    }

    public String getNastanljiva() {
        return nastanljiva;
    }

    public void setNastanljiva(String nastanljiva) {
        this.nastanljiva = nastanljiva;
    }

    public int getId_poznatog_objekta() {
        return id_poznatog_objekta;
    }

    public void setId_poznatog_objekta(int id_poznatog_objekta) {
        this.id_poznatog_objekta = id_poznatog_objekta;
    }
}
