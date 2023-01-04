package project.truckio.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "vozila",schema = "project")
@Data
public class Vozilo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vozilo_id", nullable = false)
    private Integer vozilo_id;

    @Column(name = "vozilo_marka", nullable = false, length = 300)
    private String vozilo_marka;

    @Column(name = "vozilo_kapacitet", nullable = false)
    private Integer vozilo_kapacitet;


    // vrski so kompanija tip i vozac
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kompanija_id")
    private Kompanija kompanija;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tip_id")
    private Tip tip;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vozac_id")
    private Vozac vozac;

    public Vozilo(String vozilo_marka, Integer vozilo_kapacitet) {
        this.vozilo_marka = vozilo_marka;
        this.vozilo_kapacitet = vozilo_kapacitet;
    }

    public Vozilo() {}
}
