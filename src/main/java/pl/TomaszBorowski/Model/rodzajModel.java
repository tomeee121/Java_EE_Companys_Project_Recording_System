package pl.TomaszBorowski.Model;

public class rodzajModel {
    private Integer id_rodzaj;
    private String nazwa_rodzaj;

    public rodzajModel(Integer id_rodzaj, String nazwa_rodzaj) {
        this.id_rodzaj = id_rodzaj;
        this.nazwa_rodzaj = nazwa_rodzaj;
    }

    public rodzajModel(String nazwa_rodzaj) {
        this.nazwa_rodzaj = nazwa_rodzaj;
    }

    public Integer getid_rodzaj() {
        return id_rodzaj;
    }

    public String getNazwa_rodzaj() {
        return nazwa_rodzaj;
    }
}