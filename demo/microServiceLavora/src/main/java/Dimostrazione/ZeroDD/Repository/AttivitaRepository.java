package Dimostrazione.ZeroDD.Repository;


import Dimostrazione.ZeroDD.entity.Attivita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttivitaRepository extends JpaRepository<Attivita,Integer> {

    List<Attivita> findByAttivitaPadre(Integer attivitaPadre);
    Attivita findByAlias(String alias);
}
