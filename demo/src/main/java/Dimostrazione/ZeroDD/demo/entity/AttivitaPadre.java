package Dimostrazione.ZeroDD.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class AttivitaPadre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;


    @OneToMany(mappedBy = "attivitaPadre",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Attivita> attivitas;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Attivita> getAttivitas() {
        return attivitas;
    }

    public void setAttivitas(Set<Attivita> attivitas) {
        this.attivitas = attivitas;
    }
}
