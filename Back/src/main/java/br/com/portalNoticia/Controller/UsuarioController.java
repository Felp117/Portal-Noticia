package br.com.portalNoticia.Controller;

import br.com.portalNoticia.dto.UsuarioDto;
import br.com.portalNoticia.entity.Pessoa;
import br.com.portalNoticia.entity.Usuario;
import br.com.portalNoticia.services.UsuarioService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    private final UsuarioService service;

    @Autowired
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDto>> findAll() {
        List<Usuario> list = service.findAll();
        List<UsuarioDto> listDto = list.stream().map(UsuarioDto::new).toList();
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioDto> findById(@PathVariable Integer id) throws BadRequestException {
        Usuario usuario = service.findById(id);
        return ResponseEntity.ok().body(new UsuarioDto(usuario));
    }

}
