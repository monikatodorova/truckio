package project.truckio.model;

import lombok.Data;
import project.truckio.model.primarykeys.LicencaID;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "licenci",schema = "project")
public class Licenca {
    @EmbeddedId
    private LicencaID licenca_id;

    @Column(name = "licenca_vazi_od", nullable = false)
    private LocalDate licenca_vazi_od;

    @Column(name = "licenca_vazi_do", nullable = false)
    private LocalDate licenca_vazi_do;

//    // vrski
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "kompanija_id")
//    private Kompanija kompanija;
}
