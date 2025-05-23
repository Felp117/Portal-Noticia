package br.com.portalNoticia.controller;

import br.com.portalNoticia.DTO.PessoaDTO;
import br.com.portalNoticia.entity.Categoria;
import br.com.portalNoticia.entity.Pessoa;
import br.com.portalNoticia.repository.CategoriaRepository;
import br.com.portalNoticia.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping(value = "/categoria")
    public ResponseEntity<List<Categoria>> findAll() {
        return ResponseEntity.ok((List<Categoria>) categoriaRepository.findAll());
    }

    @GetMapping(value = "/categoria/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable(value = "id") Integer id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/categoria")
    public ResponseEntity<Categoria> save(@PathVariable(value = "id") Integer id, @RequestBody Categoria novoItem) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if(categoria.isPresent()) {
            return new ResponseEntity<>(categoriaRepository.save(novoItem), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping(value = "/categoria/{id}")
    public ResponseEntity<Categoria> Update(@PathVariable(value = "id") Integer id, @RequestBody Categoria updateItem) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if(categoria.isPresent()) {
            return new ResponseEntity<>(categoriaRepository.save(updateItem), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping(value = "/categoria/{id}")
    public ResponseEntity<Categoria> Delete(@PathVariable(value = "id") Integer id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if(categoria.isPresent()) {
            categoriaRepository.delete(categoria.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
