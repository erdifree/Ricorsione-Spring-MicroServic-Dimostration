package Dimostrazione.ZeroDD.Controller;

import Dimostrazione.ZeroDD.Repository.AttivitaRepository;
import Dimostrazione.ZeroDD.Service.AttivitàService;
import Dimostrazione.ZeroDD.entity.Attivita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

;

@RestController
@RequestMapping("/api/v1/attivita")
@CrossOrigin
public class AttivitaController {

    @Autowired
    AttivitaRepository attivitaRepository;

    @Autowired
    AttivitàService attivitàService;



    @PutMapping("/update")
    public boolean update() {
        List<Attivita> responese = attivitaRepository.findAll();

        if (responese.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        } else {
         attivitàService.isLavorabile(responese);
            return true;
        }
    }
}
