package project.truckio.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "gradovi",schema = "project")
@Data
public class Grad {
    @Id
    @Column(name = "grad_id", nullable = false)
    private Integer grad_id;

    @Column(name = "grad_ime", nullable = false, length = 300)
    private String grad_ime;

    public Grad(Integer grad_id, String grad_ime) {
        this.grad_id = grad_id;
        this.grad_ime = grad_ime;
    }

    public Grad() {}
}
