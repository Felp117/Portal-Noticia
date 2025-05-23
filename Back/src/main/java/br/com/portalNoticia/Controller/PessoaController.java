package br.com.portalNoticia.Controller;

import br.com.portalNoticia.Controller.util.Url;
import br.com.portalNoticia.dto.PessoaDto;
import br.com.portalNoticia.entity.Pessoa;
import br.com.portalNoticia.services.PessoaService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
        List<Pessoa> pessoa = service.findAll();
        List<PessoaDto> listDto = pessoa.stream().map(PessoaDto::new).toList();
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PessoaDto> findById(@PathVariable Integer id) throws BadRequestException {
        Pessoa pessoa = service.findById(id);
        return ResponseEntity.ok().body(new PessoaDto(pessoa));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws BadRequestException {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update( @RequestBody PessoaDto dto, @PathVariable Integer id) throws BadRequestException {
        dto.setId(id);
        Pessoa pessoa = service.fromDto(dto);
        pessoa = service.update(pessoa);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<PessoaDto> insert(@RequestBody PessoaDto dto){
        Pessoa pessoa = service.fromDto(dto);
        pessoa = service.insert(pessoa);
        URI url = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pessoa.getId()).toUri();
        return ResponseEntity.created(url).build();
    }
}
