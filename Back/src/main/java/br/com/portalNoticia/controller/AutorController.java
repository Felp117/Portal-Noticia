package br.com.portalNoticia.controller;

import br.com.portalNoticia.dto.AutorDto;
import br.com.portalNoticia.entity.Autor;
import br.com.portalNoticia.services.AutorService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/autor")
public class AutorController {

    private final AutorService service;

    @Autowired
    public AutorController(AutorService autorService) {
        this.service = autorService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AutorDto> findById(@PathVariable Integer id) throws BadRequestException {
        Autor autor = service.findById(id);
        return ResponseEntity.ok(new AutorDto(autor));
    }

}
