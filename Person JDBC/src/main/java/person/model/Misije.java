package person.model;

public class Misije {

    private int id_misije;
    private String naziv;
    private String poznati_objekti_naziv;
    private int id_poznatog_objekta;
    private String svemirski_brod;
    private int predvidjeno_vreme_putovanja;

    public Misije(int id_misije, String naziv, int id_poznatog_objekta, String svemirski_brod, int predvidjeno_vreme_putovanja,String poznati_objekti_naziv) {
        this.id_misije = id_misije;
        this.naziv = naziv;
        this.id_poznatog_objekta = id_poznatog_objekta;
        this.svemirski_brod = svemirski_brod;
        this.predvidjeno_vreme_putovanja = predvidjeno_vreme_putovanja;
        this.poznati_objekti_naziv=poznati_objekti_naziv;
    }

    public String getPoznati_objekti_naziv() {
        return poznati_objekti_naziv;
    }

    public void setPoznati_objekti_naziv(String poznati_objekti_naziv) {
        this.poznati_objekti_naziv = poznati_objekti_naziv;
    }

    public int getId_misije() {
        return id_misije;
    }

    public void setId_misije(int id_misije) {
        this.id_misije = id_misije;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getId_poznatog_objekta() {
        return id_poznatog_objekta;
    }

    public void setId_poznatog_objekta(int id_poznatog_objekta) {
        this.id_poznatog_objekta = id_poznatog_objekta;
    }

    public String getSvemirski_brod() {
        return svemirski_brod;
    }

    public void setSvemirski_brod(String svemirski_brod) {
        this.svemirski_brod = svemirski_brod;
    }

    public int getPredvidjeno_vreme_putovanja() {
        return predvidjeno_vreme_putovanja;
    }

    public void setPredvidjeno_vreme_putovanja(int predvidjeno_vreme_putovanja) {
        this.predvidjeno_vreme_putovanja = predvidjeno_vreme_putovanja;
    }
}
