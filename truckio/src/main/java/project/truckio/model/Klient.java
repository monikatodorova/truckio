package project.truckio.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "klienti",schema = "project")
public class Klient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "klient_id", nullable = false)
    private Integer klient_id;

    @Column(name = "klient_ime", nullable = false, length = 300)
    private String klient_ime;

    @Column(name = "klient_prezime", nullable = false, length = 300)
    private String klient_prezime;

    @Column(name = "klient_email", nullable = false, length = 300)
    private String email;

    @Column(name = "klient_password", nullable = false, length = 300)
    private String password;

    @Column(name = "klient_telefon", nullable = false, length = 300)
    private String klient_telefon;

    public Klient(String klient_ime, String klient_prezime, String email, String password, String klient_telefon) {
        this.klient_ime = klient_ime;
        this.klient_prezime = klient_prezime;
        this.email = email;
        this.password = password;
        this.klient_telefon = klient_telefon;
    }

    public Klient() {

    }
}
