package project.truckio.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "dispeceri",schema = "project")
@Data
public class Dispecer {
    @Id
    @Column(name = "dispecer_id", nullable = false)
    private Integer dispecer_id;

    @MapsId
    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "dispecer_id", nullable = false)
    private Vraboten vraboten;
}
