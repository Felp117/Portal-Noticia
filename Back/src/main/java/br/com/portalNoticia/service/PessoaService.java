package br.com.portalNoticia.service;

import br.com.portalNoticia.entity.Pessoa;
import br.com.portalNoticia.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public Pessoa save(Pessoa pessoa){
        return this.pessoaRepository.save(pessoa);
    }

    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    public Optional<Pessoa> findById(Integer id) {
        return pessoaRepository.findById(id);
    }

    public Optional<Pessoa> Delete(Integer id) {
        return pessoaRepository.findById(id);
    }

}
