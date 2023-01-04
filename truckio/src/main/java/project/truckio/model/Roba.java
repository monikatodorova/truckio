package project.truckio.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "roba",schema = "project")
@Data
public class Roba {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roba_id", nullable = false)
    private Integer roba_id;

    @Column(name = "roba_kolicina", nullable = false)
    private Integer roba_kolicina;

    // vrski
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rezervacija_id")
    private Rezervacija rezervacija;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kategorija_id")
    private Kategorija kategorija;
}
