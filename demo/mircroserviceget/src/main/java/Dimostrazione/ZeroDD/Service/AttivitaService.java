package Dimostrazione.ZeroDD.Service;


import Dimostrazione.ZeroDD.DTO.AttivitaRequest;
import Dimostrazione.ZeroDD.DTO.AttivitaResponse;
import Dimostrazione.ZeroDD.Repository.AttivitaRepository;
import Dimostrazione.ZeroDD.entity.Attivita;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AttivitaService {

    private final AttivitaRepository attivitaRepository;


public void  creaAttivita(AttivitaRequest attivitaRequest){

    Attivita attivita= Attivita.builder()
            .alias(attivitaRequest.getAlias())
            .lavorata(attivitaRequest.isLavorata())
            .attivitaPadre(attivitaRequest.getAttivitaPadre())
            .build();
    attivitaRepository.save(attivita);
    log.info("Attivita {} inserita nel Data Base",attivita.getId());
}

    public List<AttivitaResponse> getAllAttivita() {
    List<Attivita> response= attivitaRepository.findAll();
    return response.stream().map(this::mapToAttivitaResponse).toList();
    }

    private AttivitaResponse mapToAttivitaResponse(Attivita attivita) {
    return  AttivitaResponse.builder()
            .id(attivita.getId())
            .alias(attivita.getAlias())
            .lavorata(attivita.isLavorata())
            .attivitaPadre(attivita.getAttivitaPadre())
            .build();
    }
}
