package br.com.portalNoticia.Controller;

import br.com.portalNoticia.dto.NoticiaDto;
import br.com.portalNoticia.entity.Noticia;
import br.com.portalNoticia.services.NoticiaService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/noticia")
public class NoticiaController {

    private final NoticiaService service;

    @Autowired
    public NoticiaController(NoticiaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<NoticiaDto>> findAll() {
        List<Noticia> list = service.findAll();
        List<NoticiaDto> listDto = list.stream().map(NoticiaDto::new).toList();
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<NoticiaDto> findById(@PathVariable Integer id) throws BadRequestException {
        Noticia noticia = service.findById(id);
        return ResponseEntity.ok().body(new NoticiaDto(noticia));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws BadRequestException {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody NoticiaDto dto, @PathVariable Integer id) throws BadRequestException {
        dto.setId(id);
        Noticia noticia = service.fromDto(dto);
        noticia = service.update(noticia);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<NoticiaDto> insert(@RequestBody NoticiaDto dto) {
        Noticia noticia = service.fromDto(dto);
        noticia = service.insert(noticia);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(noticia.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
