package br.com.portalNoticia.services;

import br.com.portalNoticia.dto.PessoaDto;
import br.com.portalNoticia.entity.Pessoa;
import br.com.portalNoticia.repository.PessoaRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    public List<PessoaDto> findAll() {
        List<Pessoa> pessoa = repository.findAll();
        return Collections.singletonList(PessoaDto.convert((Pessoa) pessoa));
    }

    public PessoaDto findById(Integer id) throws BadRequestException {
        Optional<Pessoa> pessoa = repository.findById(id);
        if(pessoa.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi possivel encontrar a pessoa com ID: " + id);
        }
        return PessoaDto.convert(pessoa.get());
    }

    public PessoaDto insert(PessoaDto pessoaDto) {
        Pessoa pessoa = fromDto(pessoaDto);
        pessoa = repository.save(pessoa);
        return PessoaDto.convert(pessoa);
    }

    public void delete(Integer id) throws BadRequestException {
        repository.deleteById(id);
    }

    public PessoaDto update(PessoaDto obj, Integer id) throws BadRequestException {
        obj.setId(id);
        Pessoa pessoa = fromDto(obj);
        pessoa = repository.save(pessoa);
        return PessoaDto.convert(pessoa);
    }

    private void updatePessoa(PessoaDto NovaPessoa) {
        PessoaDto pessoa = new PessoaDto();
        NovaPessoa.setNome(pessoa.getNome());
        NovaPessoa.setEmail(pessoa.getEmail());
    }

    public Pessoa fromDto(PessoaDto pessoaDto) {
        return new Pessoa(pessoaDto.getId(), pessoaDto.getNome(), pessoaDto.getEmail());
    }

}
