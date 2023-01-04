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

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "vraboten_id")
//    private Vraboten vraboten;

//    @Column(name = "telefonski_broj", nullable = false, length = 300)
//    private String telefonski_broj;
}
