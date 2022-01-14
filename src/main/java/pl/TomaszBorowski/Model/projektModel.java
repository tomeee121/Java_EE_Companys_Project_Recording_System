package pl.TomaszBorowski.Model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public class projektModel {
    private Integer Id_projekt;
    private String nazwa_rodzaj;
    private Integer Id_rodzaj;
    private String nazwa_status;
    private Integer Id_status;
    private String nr_projekt;
    private String temat_projekt;
    private java.sql.Date data_rozpoczecia;
    private java.sql.Date data_zakonczenia;
    private BigDecimal kwota;
    private String uwagi;

    public projektModel(String nazwa_rodzaj, String nazwa_status, String nr_projekt, String temat_projekt, java.sql.Date data_rozpoczecia, java.sql.Date data_zakonczenia, BigDecimal kwota, String uwagi) {
        this.nazwa_rodzaj = nazwa_rodzaj;
        this.nazwa_status = nazwa_status;
        this.nr_projekt = nr_projekt;
        this.temat_projekt = temat_projekt;
        this.data_rozpoczecia = data_rozpoczecia;
        this.data_zakonczenia = data_zakonczenia;
        this.kwota = kwota;
        this.uwagi = uwagi;
    }

    public projektModel(Integer id_rodzaj, Integer id_status, String nr_projekt, String temat_projekt, java.sql.Date data_rozpoczecia, java.sql.Date data_zakonczenia, BigDecimal kwota, String uwagi) {
        this.Id_rodzaj = id_rodzaj;
        this.Id_status = id_status;
        this.nr_projekt = nr_projekt;
        this.temat_projekt = temat_projekt;
        this.data_rozpoczecia = data_rozpoczecia;
        this.data_zakonczenia = data_zakonczenia;
        this.kwota = kwota;
        this.uwagi = uwagi;
    }

    public Integer getId_projekt() {
        return Id_projekt;
    }

    public String getnazwa_rodzaj() {
        return nazwa_rodzaj;
    }

    public Integer getId_rodzaj() {
        return Id_rodzaj;
    }

    public String getnazwa_status() {
        return nazwa_rodzaj;
    }

    public Integer getId_status() {
        return Id_status;
    }

    public String getNr_projekt() {
        return nr_projekt;
    }

    public String getTemat_projekt() {
        return temat_projekt;
    }

    public java.sql.Date getData_rozpoczecia() {
        return data_rozpoczecia;
    }

    public java.sql.Date getData_zakonczenia() {
        return data_zakonczenia;
    }

    public BigDecimal getKwota() {
        return kwota;
    }

    public String getUwagi() {
        return uwagi;
    }
}
