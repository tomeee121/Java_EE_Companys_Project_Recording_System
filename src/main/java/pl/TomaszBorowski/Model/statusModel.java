package pl.TomaszBorowski.Model;

public class statusModel {
    private Integer id_status;
    private String nazwa_status;

    public statusModel(Integer id_status, String nazwa_status) {
        this.id_status = id_status;
        this.nazwa_status = nazwa_status;
    }

    public statusModel(String nazwa_status) {
        this.nazwa_status = nazwa_status;
    }

    public Integer getid_status() {
        return id_status;
    }

    public String getNazwa_status() {
        return nazwa_status;
    }
}
