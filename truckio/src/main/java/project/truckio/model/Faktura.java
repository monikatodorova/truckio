package project.truckio.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "fakturi",schema = "project")
@Data
public class Faktura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "faktura_id", nullable = false)
    private Integer faktura_id;

    @Column(name = "faktura_iznos", nullable = false)
    private Integer faktura_iznos;

    // vrski
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rezervacija_id")
    private Rezervacija rezervacija;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "administrator_id")
    private Administrator administrator;

    public Faktura(Integer faktura_iznos, Rezervacija rezervacija, Administrator administrator) {
        this.faktura_iznos = faktura_iznos;
        this.rezervacija = rezervacija;
        this.administrator = administrator;
    }

    public Faktura() {

    }
}
