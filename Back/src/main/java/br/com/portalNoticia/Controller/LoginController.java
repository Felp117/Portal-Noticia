package br.com.portalNoticia.Controller;

import br.com.portalNoticia.dto.LoginDTO;
import br.com.portalNoticia.dto.UsuarioDto;
import br.com.portalNoticia.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

    @Autowired
    private final UsuarioService service;

    public LoginController(UsuarioService usuarioService) {
        this.service = usuarioService;
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Void> login(@RequestBody LoginDTO loginDTO) {
        service.login(loginDTO);
        return ResponseEntity.ok().build();
    }
}
