package project.truckio.model.primarykeys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

@Data
@Embeddable
public class KompaniiRutiID implements Serializable {
    private static final long serialVersionUID = -8688686914310645850L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kompanija_id", nullable = false)
    private Integer kompanija_id;

    @Column(name = "ruta_pocnuva_vo", nullable = false)
    private String ruta_pocnuva_vo;

    @Column(name = "ruta_zavrsuva_vo", nullable = false)
    private String ruta_zavrsuva_vo;
}
