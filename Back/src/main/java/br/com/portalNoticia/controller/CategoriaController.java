package br.com.portalNoticia.controller;

import br.com.portalNoticia.DTO.PessoaDTO;
import br.com.portalNoticia.entity.Pessoa;
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
    private PessoaRepository pessoaRepository;

    @GetMapping(value = "/pessoa")
    public ResponseEntity<List<Pessoa>> findAll() {
        return ResponseEntity.ok((List<Pessoa>) pessoaRepository.findAll());
    }

    @GetMapping(value = "/pessoa/{id}")
    public ResponseEntity<Pessoa> findById(@PathVariable(value = "id") Integer id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        return pessoa.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/pessoa")
    public ResponseEntity<Pessoa> save(@PathVariable(value = "id") Integer id, @RequestBody PessoaDTO novoItem) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        if(pessoa.isPresent()) {
            return new ResponseEntity<>(pessoaRepository.save(novoItem.converter()), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping(value = "/pessoa/{id}")
    public ResponseEntity<Pessoa> Update(@PathVariable(value = "id") Integer id, @RequestBody PessoaDTO updateItem) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        if(pessoa.isPresent()) {
            return new ResponseEntity<>(pessoaRepository.save(updateItem.converter()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping(value = "/pessoa/{id}")
    public ResponseEntity<Pessoa> Delete(@PathVariable(value = "id") Integer id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        if(pessoa.isPresent()) {
            pessoaRepository.delete(pessoa.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
