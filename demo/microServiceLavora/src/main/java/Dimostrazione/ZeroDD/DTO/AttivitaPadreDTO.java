package Dimostrazione.ZeroDD.DTO;



import Dimostrazione.ZeroDD.entity.Attivita;

import java.util.Set;

public class AttivitaPadreDTO {
    private  int id;
    private Set<Attivita> attivitas;

    public AttivitaPadreDTO() {
    }

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
