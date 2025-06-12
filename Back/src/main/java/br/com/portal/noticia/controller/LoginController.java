package br.com.portal.noticia.controller;

import br.com.portal.noticia.dto.LoginDTO;
import br.com.portal.noticia.dto.RecoveryJwtDTO;
import br.com.portal.noticia.services.AuthService;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@AllArgsConstructor
public class LoginController {

    @Autowired
    private final AuthService service;

    @PostMapping
    public ResponseEntity<Void> login(@RequestBody LoginDTO loginDTO) {
        RecoveryJwtDTO token = service.authenticateUser(loginDTO);
        return ResponseEntity.ok().build();
    }
}
