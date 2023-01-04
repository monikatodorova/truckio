package project.truckio.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "vozaci",schema = "project")
@Data
public class Vozac {
    @Id
    @Column(name = "vozac_id", nullable = false)
    private Integer vozac_id;

    @MapsId
    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vozac_id", nullable = false)
    private Vraboten vraboten;
}
