package Dimostrazione.ZeroDD.Service;


import Dimostrazione.ZeroDD.DTO.AttivitaPadreDTO;
import Dimostrazione.ZeroDD.Repository.AttivitaPadreRepository;
import Dimostrazione.ZeroDD.Repository.AttivitaRepository;
import Dimostrazione.ZeroDD.entity.Attivita;
import Dimostrazione.ZeroDD.entity.AttivitaPadre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AttivitàService {
    @Autowired
    private AttivitaRepository attivitaRepository;
    @Autowired
    AttivitaPadreRepository attivitaPadreRepository;

    public boolean isLavorabile(List<Attivita> arrivita) {
          int i=0;
          List<Attivita> temp= new ArrayList<>();
        for (Attivita attivitaa: arrivita) {
             if (attivitaa.getAttivitaPadre() == null&&!attivitaa.isLavorata()) {
              attivitaa.setLavorata(true);
              attivitaRepository.save(attivitaa);
              temp.add(attivitaa);
              i++;
            } else if (isStatoFinale(temp)==true) {
                if ("ACTIVITY4".equals(attivitaa.getAlias())){
                attivitaa.setLavorata(true);
                arrivita.get(i-1).setLavorata(false);
                attivitaRepository.save(attivitaa);
                temp.get(i-1).setLavorata(false);
                temp.add(attivitaa);
                i++;
                } else  {
                    attivitaa.setLavorata(true);
                    attivitaRepository.save(attivitaa);
                    temp.add(attivitaa);
                    i++;
                }
            } else  if ("ACTIVITY5".equals(attivitaa.getAlias())){
                 attivitaa.setLavorata(true);
                 arrivita.get(i-1).setLavorata(false);
                 arrivita.get(i-2).setLavorata(true);
                 attivitaRepository.save(attivitaa);
                 temp.get(i-1).setLavorata(false);
                 temp.get(i-2).setLavorata(true);

             }


        }


        return true;
    }

    private boolean isStatoFinale( List<Attivita> temp) {
        boolean flag=false;
        for (Attivita attivita:temp) {
            if (attivita.isLavorata()==true){
            flag=attivita.isLavorata();
        }else {
                return flag=false;
            }
        }
        return flag;
    }

}

