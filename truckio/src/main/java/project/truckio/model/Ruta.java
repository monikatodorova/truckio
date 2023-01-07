package project.truckio.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "ruti",schema = "project")
@Data
public class Ruta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ruta_id", nullable = false)
    private Integer ruta_id;

    @Column(name = "datum_poagjanje", nullable = false)
    private LocalDate datum_poagjanje;

    @Column(name = "datum_pristignuvanje", nullable = false)
    private LocalDate datum_pristiganje;

    // vrski
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zapocnuva_vo")
    private Grad zapocnuva_vo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zavrsuva_vo")
    private Grad zavrsuva_vo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dispecer_id")
    private Dispecer dispecer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vozac_id")
    private Vozac vozac;

    public Ruta(LocalDate datum_poagjanje, LocalDate datum_pristiganje, Grad zapocnuva_vo, Grad zavrsuva_vo, Dispecer dispecer, Vozac vozac) {
        this.datum_poagjanje = datum_poagjanje;
        this.datum_pristiganje = datum_pristiganje;
        this.zapocnuva_vo = zapocnuva_vo;
        this.zavrsuva_vo = zavrsuva_vo;
        this.dispecer = dispecer;
        this.vozac = vozac;
    }
}
