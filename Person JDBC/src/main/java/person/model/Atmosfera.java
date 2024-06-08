package person.model;

public class Atmosfera {

    private int id_atmosfere;

    private int procenat_kiseonika;

    private int procenat_otrovnog_gasa;
    private int procenat_neotrovnog_gasa;

    private int id_objekta;

    public Atmosfera(int id_atmosfere, int procenat_kiseonika, int procenat_otrovnog_gasa, int procenat_neotrovnog_gasa, int id_objekta) {
        this.id_atmosfere=id_atmosfere;
        this.procenat_kiseonika = procenat_kiseonika;
        this.procenat_otrovnog_gasa = procenat_otrovnog_gasa;
        this.procenat_neotrovnog_gasa = procenat_neotrovnog_gasa;
        this.id_objekta = id_objekta;
    }

    public int getId_atmosfere() {
        return id_atmosfere;
    }

    public void setId_atmosfere(int id_atmosfere) {
        this.id_atmosfere = id_atmosfere;
    }

    public int getProcenat_kiseonika() {
        return procenat_kiseonika;
    }

    public void setProcenat_kiseonika(int procenat_kiseonika) {
        this.procenat_kiseonika = procenat_kiseonika;
    }

    public int getProcenat_otrovnog_gasa() {
        return procenat_otrovnog_gasa;
    }

    public void setProcenat_otrovnog_gasa(int procenat_otrovnog_gasa) {
        this.procenat_otrovnog_gasa = procenat_otrovnog_gasa;
    }

    public int getProcenat_neotrovnog_gasa() {
        return procenat_neotrovnog_gasa;
    }

    public void setProcenat_neotrovnog_gasa(int procenat_neotrovnog_gasa) {
        this.procenat_neotrovnog_gasa = procenat_neotrovnog_gasa;
    }

    public int getId_objekta() {
        return id_objekta;
    }

    public void setId_objekta(int id_objekta) {
        this.id_objekta = id_objekta;
    }
}
