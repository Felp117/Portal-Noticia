package br.com.portalNoticia.controller;

import br.com.portalNoticia.DTO.UsuarioDTO;
import br.com.portalNoticia.entity.Usuario;
import br.com.portalNoticia.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping(value = "/pessoa")
    public ResponseEntity<List<Usuario>> findAll() {
        return ResponseEntity.ok((List<Usuario>) usuarioRepository.findAll());
    }

    @GetMapping(value = "/pessoa/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable(value = "id") Integer id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/pessoa")
    public ResponseEntity<Usuario> save(@PathVariable(value = "id") Integer id, @RequestBody UsuarioDTO novoItem) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isPresent()) {
            return new ResponseEntity<>(usuarioRepository.save(novoItem.converter()), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping(value = "/pessoa/{id}")
    public ResponseEntity<Usuario> Update(@PathVariable(value = "id") Integer id, @RequestBody UsuarioDTO updateItem) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isPresent()) {
            return new ResponseEntity<>(usuarioRepository.save(updateItem.converter()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping(value = "/pessoa/{id}")
    public ResponseEntity<Usuario> Delete(@PathVariable(value = "id") Integer id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isPresent()) {
            usuarioRepository.delete(usuario.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
