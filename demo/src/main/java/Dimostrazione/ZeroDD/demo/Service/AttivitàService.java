package Dimostrazione.ZeroDD.demo.Service;

import Dimostrazione.ZeroDD.demo.DTO.AttivitaPadreDTO;
import Dimostrazione.ZeroDD.demo.Repository.AttivitaPadreRepository;
import Dimostrazione.ZeroDD.demo.Repository.AttivitaRepository;
import Dimostrazione.ZeroDD.demo.entity.Attivita;
import Dimostrazione.ZeroDD.demo.entity.AttivitaPadre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

@Service
public class AttivitàService {

    @Autowired
    private AttivitaRepository attivitaRepository;
    @Autowired
    AttivitaPadreRepository attivitaPadreRepository;



    public boolean isLavorabile(String alias) {
        Attivita attivita = attivitaRepository.findByAlias(alias);
        if (attivita == null) {
            throw new IllegalArgumentException("Attivita non trovata per alias: " + alias);
        }

        if (attivita.getAttivitaPadre() == null) {
            return false;
        }
        // verifica ricorsiva delle attività padre
        Optional<AttivitaPadre> attivitaPadre = attivitaPadreRepository.findById(attivita.getAttivitaPadre().getId());
        AttivitaPadreDTO attivitaPadreDTO1= new AttivitaPadreDTO();
        attivitaPadreDTO1.setId(attivitaPadre.get().getId());
        attivitaPadreDTO1.setAttivitas(attivitaPadre.get().getAttivitas());
        for (Attivita padre : attivitaPadreDTO1.getAttivitas()) {
            if (!padre.isLavorata()) {

                return isStatoFinale(padre.getAlias());
            }

        }
        return true;
    }

    public boolean isStatoFinale(String alias) {
        Attivita attivita = attivitaRepository.findByAlias(alias);
        if (attivita == null) {
            throw new IllegalArgumentException("Attivita non trovata per alias: " + alias);
        }
        if (attivita.isLavorata() || attivita.getAttivitaPadre() == null) {
            return false; // se l'attività è stata lavorata o è la radice, non è uno stato finale
        }
        Optional<AttivitaPadre> attivitaFiglie = attivitaPadreRepository.findById(attivita.getAttivitaPadre().getId());
        AttivitaPadreDTO attivitaPadreDTO= new AttivitaPadreDTO();
        attivitaPadreDTO.setId(attivitaFiglie.get().getId());
        attivitaPadreDTO.setAttivitas(attivitaFiglie.get().getAttivitas());
        for (Attivita figlia : attivitaPadreDTO.getAttivitas()) {
            if (!figlia.isLavorata()) {
                if(figlia.getId()==4){
                    Optional<Attivita> activity3= attivitaRepository.findById(3);
                    Attivita figlia1= activity3.get();
                    figlia1.setLavorata(false);
                    attivitaRepository.save(figlia1);
                    return false;
                } else if(figlia.getId()==5){
                    Optional<Attivita> activity4= attivitaRepository.findById(4);
                    activity4.get().setLavorata(false);
                    attivitaRepository.save(activity4.get());
                    Optional<Attivita> activity3= attivitaRepository.findById(3);
                    activity3.get().setLavorata(true);
                    attivitaRepository.save(activity3.get());
                    return false;
                } else if(figlia.getId()==6){
                    Optional<Attivita> s= attivitaRepository.findById(5);
                    Attivita figlia1= s.get();
                    if (figlia1.isLavorata()) {
                        return true;

                    }
                }

                return false; // se c'è almeno una figlia non lavorata, non è uno stato finale
            }
        }
        return true;
    }
}

