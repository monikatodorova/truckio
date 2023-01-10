package project.truckio.model;

import lombok.Data;
import org.hibernate.annotations.Immutable;
import project.truckio.model.primarykeys.KompaniiRutiID;
import project.truckio.model.primarykeys.RelacijaRezervaciiID;

import javax.persistence.*;

@Data
@Entity
@Immutable
@Table(name = "kompanii_ruti",schema = "project")
public class KompaniiRuti {
    @EmbeddedId
    private KompaniiRutiID kompaniiRutiID;

    @MapsId("kompanija_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kompanija_id")
    private Kompanija kompanija;

    @Column(name = "broj_rezervacii", nullable = false)
    private Long broj_rezervacii;

    @Column(name = "vkupna_zarabotka", nullable = false)
    private Long vkupna_zarabotka;
}
