package person.model;

public class Stambeni_Objekat {

    private int id_stambenog_objekta;
    private int vrednost;
    private int kvadratura;
    private double ocena;
    private int id_objekta;
    private int id_osobe;

    public Stambeni_Objekat(int id_stambenog_objekta, int vrednost, int kvadratura, double ocena, int id_objekta, int id_osobe) {
        this.id_stambenog_objekta = id_stambenog_objekta;
        this.vrednost = vrednost;
        this.kvadratura = kvadratura;
        this.ocena = ocena;
        this.id_objekta = id_objekta;
        this.id_osobe = id_osobe;
    }

    public int getId_stambenog_objekta() {
        return id_stambenog_objekta;
    }

    public void setId_stambenog_objekta(int id_stambenog_objekta) {
        this.id_stambenog_objekta = id_stambenog_objekta;
    }

    public int getVrednost() {
        return vrednost;
    }

    public void setVrednost(int vrednost) {
        this.vrednost = vrednost;
    }

    public int getKvadratura() {
        return kvadratura;
    }

    public void setKvadratura(int kvadratura) {
        this.kvadratura = kvadratura;
    }

    public double getOcena() {
        return ocena;
    }

    public void setOcena(double ocena) {
        this.ocena = ocena;
    }

    public int getId_objekta() {
        return id_objekta;
    }

    public void setId_objekta(int id_objekta) {
        this.id_objekta = id_objekta;
    }

    public int getId_osobe() {
        return id_osobe;
    }

    public void setId_osobe(int id_osobe) {
        this.id_osobe = id_osobe;
    }
}
