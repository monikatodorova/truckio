package project.truckio.model;

import lombok.Data;
import org.hibernate.annotations.Immutable;
import project.truckio.model.primarykeys.KompaniiKlientiID;
import project.truckio.model.primarykeys.RelacijaRezervaciiID;

import javax.persistence.*;

@Data
@Entity
@Immutable
@Table(name = "relacija_rezervacii",schema = "project")
public class RelacijaRezervacii {
    @EmbeddedId
    private RelacijaRezervaciiID relacijaRezervaciiID;

    @Column(name = "broj_zavrseni_rezervacii", nullable = false)
    private Long broj_zavrseni_rezervacii;

    @MapsId("kompanija_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kompanija_id")
    private Kompanija kompanija;

    @MapsId("pocnuva_vo_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pocnuva_vo_id")
    private Grad pocnuva_vo;

    @MapsId("zavrsuva_vo_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zavrsuva_vo_id")
    private Grad zavrsuva_vo;
}
