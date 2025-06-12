package br.com.portal.noticia.services;

import br.com.portal.noticia.dto.PessoaDto;
import br.com.portal.noticia.entity.Pessoa;
import br.com.portal.noticia.repository.PessoaRepository;
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

}
