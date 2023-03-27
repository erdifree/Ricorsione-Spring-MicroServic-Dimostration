package Dimostrazione.ZeroDD.demo.Repository;

import Dimostrazione.ZeroDD.demo.entity.Attivita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttivitaRepository extends JpaRepository<Attivita,Integer> {

    List<Attivita> findByAttivitaPadre(Integer attivitaPadre);
    Attivita findByAlias(String alias);
}
