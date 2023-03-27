package Dimostrazione.ZeroDD.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity

public class Attivita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String alias;
    private boolean lavorata;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="attivitaPadre")

    private AttivitaPadre attivitaPadre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public boolean isLavorata() {
        return lavorata;
    }

    public void setLavorata(boolean lavorata) {
        this.lavorata = lavorata;
    }

    public AttivitaPadre getAttivitaPadre() {
        return attivitaPadre;
    }

    public void setAttivitaPadre(AttivitaPadre attivitaPadre) {
        this.attivitaPadre = attivitaPadre;
    }
}
