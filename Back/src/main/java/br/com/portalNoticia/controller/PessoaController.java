package br.com.portalNoticia.controller;

import br.com.portalNoticia.entity.Pessoa;
import br.com.portalNoticia.DTO.PessoaDTO;
import br.com.portalNoticia.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RequestMapping(value = "/pessoa")
@RestController
public class PessoaController {


    private final PessoaService pessoaService;

    @Autowired
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    public ResponseEntity<List<Pessoa>> findAll() {
        return ResponseEntity.ok(pessoaService.findAll());
    }

    @GetMapping(value = "/pessoa/{id}")
    public ResponseEntity<Pessoa> findById(@PathVariable(value = "id") Integer id) {
        Optional<Pessoa> pessoa = pessoaService.findById(id);
        return pessoa.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/pessoa")
    public ResponseEntity<PessoaDTO> save(@RequestBody PessoaDTO novoItem) {
        Pessoa pessoa = pessoaService.save(novoItem.converter());
        return ResponseEntity.ok(PessoaDTO.converterEntidade(pessoa));
    }

    @PutMapping(value = "/pessoa/{id}")
    public ResponseEntity<Pessoa> Update(@PathVariable(value = "id") Integer id, @RequestBody PessoaDTO updateItem) {
        Optional<Pessoa> pessoa = pessoaService.findById(id);
        if(pessoa.isPresent()) {
            return new ResponseEntity<>(pessoaService.save(updateItem.converter()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping(value = "/pessoa/{id}")
    public ResponseEntity<Pessoa> Delete(@PathVariable(value = "id") Integer id) {
        Optional<Pessoa> pessoa = pessoaService.findById(id);
        if(pessoa.isPresent()) {
            pessoaService.Delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
