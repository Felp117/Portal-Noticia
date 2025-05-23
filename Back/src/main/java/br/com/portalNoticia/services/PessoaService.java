package br.com.portalNoticia.services;

import br.com.portalNoticia.dto.PessoaDto;
import br.com.portalNoticia.entity.Pessoa;
import br.com.portalNoticia.repository.PessoaRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    public List<Pessoa> findAll() {
        return repository.findAll();
    }

    public Pessoa findById(Integer id) throws BadRequestException {
        Optional<Pessoa> pessoa = repository.findById(id);
        if(pessoa.isEmpty()) {
            throw new BadRequestException("Pessoa não encontrada");
        }
        return pessoa.get();
    }

    public Pessoa insert(Pessoa pessoa) {
        return repository.save(pessoa);
    }

    public void delete(Integer id) throws BadRequestException {
        findById(id);
        repository.deleteById(id);
    }

    public Pessoa update(Pessoa obj) throws BadRequestException {
        Pessoa pessoa = findById(obj.getId());
        updatePessoa(pessoa, obj);
        return repository.save(pessoa);
    }

    private void updatePessoa(Pessoa NovaPessoa, Pessoa pessoa) {
        NovaPessoa.setNome(pessoa.getNome());
        NovaPessoa.setEmail(pessoa.getEmail());
    }

    public Pessoa fromDto(PessoaDto pessoaDto) {
        return new Pessoa(pessoaDto.getId(), pessoaDto.getNome(), pessoaDto.getEmail());
    }

}
