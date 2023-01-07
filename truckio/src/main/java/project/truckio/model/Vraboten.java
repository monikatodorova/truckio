package project.truckio.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "vraboteni",schema = "project")
public class Vraboten {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vraboten_id", nullable = false)
    private Integer vraboten_id;

    @Column(name = "vraboten_ime", nullable = false, length = 300)
    private String vraboten_ime;

    @Column(name = "vraboten_prezime", nullable = false, length = 300)
    private String vraboten_prezime;

    @Column(name = "vraboten_email", nullable = false, length = 300)
    private String vraboten_email;

    @Column(name = "vraboten_password", nullable = false, length = 300)
    private String vraboten_password;

    // vrska so kompanija
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kompanija_id")
    private Kompanija kompanija;

    public Vraboten(String vraboten_ime, String vraboten_prezime, String vraboten_email, String vraboten_password, Kompanija kompanija) {
        this.vraboten_ime = vraboten_ime;
        this.vraboten_prezime = vraboten_prezime;
        this.vraboten_email = vraboten_email;
        this.vraboten_password = vraboten_password;
        this.kompanija = kompanija;
    }

    public Vraboten() {}
}
