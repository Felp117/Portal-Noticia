package br.com.portalNoticia.Controller;

import br.com.portalNoticia.Controller.util.Url;
import br.com.portalNoticia.dto.AutorDto;
import br.com.portalNoticia.dto.PessoaDto;
import br.com.portalNoticia.entity.Autor;
import br.com.portalNoticia.entity.Usuario;
import br.com.portalNoticia.services.AutorService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
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
