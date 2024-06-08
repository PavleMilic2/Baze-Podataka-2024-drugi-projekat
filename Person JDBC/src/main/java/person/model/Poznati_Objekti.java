package person.model;

public class Poznati_Objekti {

    private int id_poznatog_objekta;
    private String vrsta;
    private int velicina;
    private int udaljenost;
    private String prvobitni_naziv;

    public Poznati_Objekti(int id_poznatog_objekta, String vrsta, int velicina, int udaljenost, String prvobitni_naziv) {
        this.id_poznatog_objekta = id_poznatog_objekta;
        this.vrsta = vrsta;
        this.velicina = velicina;
        this.udaljenost = udaljenost;
        this.prvobitni_naziv = prvobitni_naziv;
    }

    public int getId_poznatog_objekta() {
        return id_poznatog_objekta;
    }

    public void setId_poznatog_objekta(int id_poznatog_objekta) {
        this.id_poznatog_objekta = id_poznatog_objekta;
    }

    public String getVrsta() {
        return vrsta;
    }

    public void setVrsta(String vrsta) {
        this.vrsta = vrsta;
    }

    public int getVelicina() {
        return velicina;
    }

    public void setVelicina(int velicina) {
        this.velicina = velicina;
    }

    public int getUdaljenost() {
        return udaljenost;
    }

    public void setUdaljenost(int udaljenost) {
        this.udaljenost = udaljenost;
    }

    public String getPrvobitni_naziv() {
        return prvobitni_naziv;
    }

    public void setPrvobitni_naziv(String prvobitni_naziv) {
        this.prvobitni_naziv = prvobitni_naziv;
    }
}
