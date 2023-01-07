package project.truckio.model;

import lombok.Data;
import project.truckio.model.primarykeys.VrabotenTelefoniID;

import javax.persistence.*;

@Data
@Entity
@Table(name = "vraboteni_telefoni",schema = "project")
public class VrabotenTelefoni {

    @EmbeddedId
    private VrabotenTelefoniID vrabotenTelefoniID;

    @MapsId("vraboten_id")
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vraboten_id", nullable = false)
    private Vraboten vraboten;

    public VrabotenTelefoni(VrabotenTelefoniID vrabotenTelefoniID, Vraboten vraboten) {
        this.vrabotenTelefoniID = vrabotenTelefoniID;
        this.vraboten = vraboten;
    }

    public VrabotenTelefoni() {

    }
}
