package project.truckio.model.primarykeys;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Embeddable
public class LicencaID implements Serializable {
    private static final long serialVersionUID = -8688686914310645850L;

    @Column(name = "licenca_id", nullable = false)
    private Integer licenca_id;

    @Column(name = "kompanija_id", nullable = false)
    private Integer kompanija_id;
}
