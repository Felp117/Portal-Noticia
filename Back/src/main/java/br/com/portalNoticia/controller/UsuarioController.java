package br.com.portalNoticia.controller;

import br.com.portalNoticia.dto.UsuarioDto;
import br.com.portalNoticia.entity.Usuario;
import br.com.portalNoticia.services.UsuarioService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/usuario")
@CrossOrigin(origins = "http://localhost:4200")
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

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody UsuarioDto dto) {
        service.cadastrar(dto);
        return ResponseEntity.ok(Map.of("mensagem", "Usuário cadastrado com sucesso"));
    }

}
