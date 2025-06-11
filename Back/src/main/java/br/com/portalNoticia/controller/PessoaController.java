package br.com.portalNoticia.controller;

import br.com.portalNoticia.dto.PessoaDto;
import br.com.portalNoticia.services.PessoaService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

    private final PessoaService service;

    @Autowired
    public PessoaController(PessoaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PessoaDto>> findAll() {
        List<PessoaDto> pessoa = service.findAll();
        List<PessoaDto> listDto = pessoa.stream().map(PessoaDto::new).toList();
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PessoaDto> findById(@PathVariable Integer id) throws BadRequestException {
        PessoaDto pessoa = service.findById(id);
        return ResponseEntity.ok(pessoa);
    }

}
