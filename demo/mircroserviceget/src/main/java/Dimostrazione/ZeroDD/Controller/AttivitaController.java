package Dimostrazione.ZeroDD.Controller;

;
import Dimostrazione.ZeroDD.DTO.AttivitaRequest;
import Dimostrazione.ZeroDD.DTO.AttivitaResponse;
import Dimostrazione.ZeroDD.Repository.AttivitaRepository;

import Dimostrazione.ZeroDD.Service.AttivitaService;
import Dimostrazione.ZeroDD.entity.Attivita;
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
    private AttivitaService attivitaService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AttivitaResponse> getAllAttivita() {
     List<AttivitaResponse> result=attivitaService.getAllAttivita();

        return    result;
    }

    @PostMapping("/insert")
    @ResponseStatus(HttpStatus.CREATED)
    public void  createdAttivita(@RequestBody AttivitaRequest attivitaRequest){
        attivitaService.creaAttivita(attivitaRequest);
    }




}
