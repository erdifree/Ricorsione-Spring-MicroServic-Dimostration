package Dimostrazione.ZeroDD.DTO;

import Dimostrazione.ZeroDD.entity.AttivitaPadre;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AttivitaResponse {

    private int id;
    private String alias;
    private boolean lavorata;
    private AttivitaPadre attivitaPadre;
}
