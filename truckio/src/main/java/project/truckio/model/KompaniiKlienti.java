package project.truckio.model;

import lombok.Data;
import org.hibernate.annotations.Immutable;
import project.truckio.model.primarykeys.KompaniiKlientiID;
import project.truckio.model.primarykeys.LicencaID;

import javax.persistence.*;

@Data
@Entity
@Immutable
@Table(name = "kompanii_klienti",schema = "project")
public class KompaniiKlienti {
    @EmbeddedId
    private KompaniiKlientiID kompaniiKlientiID;

    @Column(name = "kompanija_ime", nullable = false, length = 300)
    private String kompanija_ime;

    @Column(name = "klient_ime", nullable = false, length = 300)
    private String klient_ime;

    @Column(name = "klient_prezime", nullable = false, length = 300)
    private String klient_prezime;

    @Column(name = "suma_fakturi", nullable = false)
    private Long suma_fakturi;

    @Column(name = "broj_na_rezervacii", nullable = false)
    private Long broj_na_rezervacii;

    @MapsId("kompanija_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kompanija_id")
    private Kompanija kompanija;

    @MapsId("klient_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "klient_id")
    private Klient klient;
}
