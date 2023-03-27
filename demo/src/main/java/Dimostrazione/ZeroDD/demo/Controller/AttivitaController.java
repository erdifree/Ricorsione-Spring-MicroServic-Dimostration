package Dimostrazione.ZeroDD.demo.Controller;

import Dimostrazione.ZeroDD.demo.Repository.AttivitaRepository;
import Dimostrazione.ZeroDD.demo.Service.AttivitàService;
import Dimostrazione.ZeroDD.demo.entity.Attivita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/attivita")
@CrossOrigin
public class AttivitaController {

    @Autowired
    AttivitaRepository attivitaRepository;

    @Autowired
    AttivitàService attivitàService;

    @GetMapping
    public List<Attivita> getAll() {
        return attivitaRepository.findAll();
    }

    @PutMapping("/update")
    public boolean update() {
        List<Attivita> responese = attivitaRepository.findAll();

        if (responese.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        } else {
            for (Attivita attivitaa: responese) {
                boolean flag = attivitàService.isLavorabile(attivitaa.getAlias());
                if (!flag) {
                    attivitaa.setLavorata(true);
                    attivitaRepository.save(attivitaa);
                }
            }
            return true;
        }
    }
}
