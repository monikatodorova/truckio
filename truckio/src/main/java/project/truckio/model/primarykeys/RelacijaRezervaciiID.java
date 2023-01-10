package project.truckio.model.primarykeys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

@Data
@Embeddable
public class RelacijaRezervaciiID implements Serializable {
    private static final long serialVersionUID = -8688686914310645850L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kompanija_id", nullable = false)
    private Integer kompanija_id;

    @Column(name = "vo_godina", nullable = false)
    private java.math.BigDecimal vo_godina;

    @Column(name = "pocnuva_vo_id", nullable = false)
    private Integer pocnuva_vo_id;

    @Column(name = "zavrsuva_vo_id", nullable = false)
    private Integer zavrsuva_vo_id;
}
