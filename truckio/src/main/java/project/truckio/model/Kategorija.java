package project.truckio.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "kategorii",schema = "project")
@Data
public class Kategorija {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kategorija_id", nullable = false)
    private Integer kategorija_id;

    @Column(name = "kategorija_ime", nullable = false, length = 300)
    private String kategorija_ime;

    public Kategorija(String kategorija_ime) {
        this.kategorija_ime = kategorija_ime;
    }

    public Kategorija() {

    }
}
