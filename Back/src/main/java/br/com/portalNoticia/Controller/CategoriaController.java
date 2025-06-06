package br.com.portalNoticia.Controller;

import br.com.portalNoticia.dto.CategoriaDto;
import br.com.portalNoticia.entity.Categoria;
import br.com.portalNoticia.services.CategoriaService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaController {

    private final CategoriaService service;

    @Autowired
    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDto>> findAll() {
        List<Categoria> list = service.findAll();
        List<CategoriaDto> listDto = list.stream().map(CategoriaDto::new).toList();
        return ResponseEntity.ok().body(listDto);
    }

}
