package Dimostrazione.ZeroDD.DTO;

import Dimostrazione.ZeroDD.entity.AttivitaPadre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AttivitaRequest {


    private String alias;
    private boolean lavorata;
    private AttivitaPadre attivitaPadre;
}
