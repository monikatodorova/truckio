package project.truckio.model.primarykeys;

import lombok.Data;
import project.truckio.model.Vraboten;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Embeddable
public class VrabotenTelefoniID implements Serializable {
    private static final long serialVersionUID = -8688686914310645850L;

    @Column(name = "vraboten_id", nullable = false)
    private Integer vraboten_id;

    @Column(name = "telefonski_broj", nullable = false, length = 300)
    private String telefonski_broj;

    public VrabotenTelefoniID(Integer vraboten_id, String telefonski_broj) {
        this.vraboten_id = vraboten_id;
        this.telefonski_broj = telefonski_broj;
    }

    public VrabotenTelefoniID() {

    }
}
