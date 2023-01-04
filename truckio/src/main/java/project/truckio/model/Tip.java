package project.truckio.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tipovi",schema = "project")
@Data
public class Tip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tip_id", nullable = false)
    private Integer tip_id;

    @Column(name = "tip_ime", nullable = false, length = 300)
    private String tip_ime;

    public Tip(String tip_ime) {
        this.tip_ime = tip_ime;
    }

    public Tip() {}
}
