package project.truckio.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "rezervacii",schema = "project")
@Data
public class Rezervacija {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rezervacija_id", nullable = false)
    private Integer rezervacija_id;

    @Column(name = "rezervacija_status", nullable = false, length = 300)
    private String rezervacija_status;

    // vrski
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "klient_id")
    private Klient klient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ruta_id")
    private Ruta ruta;

    public Rezervacija(String rezervacija_status, Klient klient, Ruta ruta) {
        this.rezervacija_status = rezervacija_status;
        this.klient = klient;
        this.ruta = ruta;
    }

    public Rezervacija() {

    }
}
