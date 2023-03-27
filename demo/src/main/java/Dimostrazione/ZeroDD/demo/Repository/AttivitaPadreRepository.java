package Dimostrazione.ZeroDD.demo.Repository;

import Dimostrazione.ZeroDD.demo.entity.Attivita;
import Dimostrazione.ZeroDD.demo.entity.AttivitaPadre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttivitaPadreRepository  extends JpaRepository<AttivitaPadre,Integer> {
}
