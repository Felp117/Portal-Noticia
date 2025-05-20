package br.com.portalNoticia.service;

import br.com.portalNoticia.entity.Pessoa;
import br.com.portalNoticia.models.PessoaDTO;
import br.com.portalNoticia.repository.PessoaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaDTO findById(Integer id) {
        Optional<Pessoa> obj = pessoaRepository.findById(id);
        Pessoa pessoa = obj.orElseThrow(()-> new EntityNotFoundException("Entidade não encontrada"));
        return new PessoaDTO(pessoa.getNome(), pessoa.getEmail());
    }

}
