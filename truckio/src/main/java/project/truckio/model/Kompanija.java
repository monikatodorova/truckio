package project.truckio.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "kompanii",schema = "project")
public class Kompanija {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kompanija_id", nullable = false)
    private Integer kompanija_id;

    @Column(name = "kompanija_ime", nullable = false, length = 300)
    private String kompanija_ime;

    @Column(name = "kompanija_adresa", nullable = false, length = 300)
    private String kompanija_adresa;

    @Column(name = "kompanija_telefon", nullable = false, length = 300)
    private String kompanija_telefon;

    public Kompanija(String kompanija_ime, String kompanija_adresa, String kompanija_telefon) {
        this.kompanija_ime = kompanija_ime;
        this.kompanija_adresa = kompanija_adresa;
        this.kompanija_telefon = kompanija_telefon;
    }

    public Kompanija() {}

    public String getIme() {
        return kompanija_ime;
    }

}
