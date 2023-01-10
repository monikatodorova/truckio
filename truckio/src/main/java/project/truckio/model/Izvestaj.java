package project.truckio.model;

import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@Entity
@Immutable
@Table(name = "izvestaj_kompanii",schema = "project")
public class Izvestaj {
    @Id
    @Column(name = "kompanija_id", nullable = false)
    private Integer kompanija_id;

    @MapsId
    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "kompanija_id", nullable = false)
    private Kompanija kompanija;

    @Column(name = "kompanija_ime", nullable = false, length = 300)
    private String kompanija_ime;

    @Column(name = "broj_vraboteni", nullable = false)
    private Long broj_vraboteni;

    @Column(name = "vkupno_klienti", nullable = false)
    private Long vkupno_klienti;

    @Column(name = "vkupna_zarabotka", nullable = false)
    private Long vkupna_zarabotka;

    @Column(name = "vkupno_rezervacii", nullable = false)
    private Long vkupno_rezervacii;

    @Column(name = "vkupno_aktivni_rezervacii", nullable = false)
    private Long vkupno_aktivni_rezervacii;

    @Column(name = "vkupno_zavrseni_rezervacii", nullable = false)
    private Long vkupno_zavrseni_rezervacii;

    @Column(name = "vkupno_otkazani_rezervacii", nullable = false)
    private Long vkupno_otkazani_rezervacii;

    @Column(name = "vkupno_za_odobruvanje_rezervacii", nullable = false)
    private Long vkupno_za_odobruvanje_rezervacii;
}
