package project.truckio.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "administratori",schema = "project")
@Data
public class Administrator {
    @Id
    @Column(name = "administrator_id", nullable = false)
    private Integer administrator_id;

    @MapsId
    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "administrator_id", nullable = false)
    private Vraboten vraboten;
}
