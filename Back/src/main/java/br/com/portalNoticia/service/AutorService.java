package br.com.portalNoticia.service;

import br.com.portalNoticia.entity.Autor;
import br.com.portalNoticia.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public Autor findById(Integer id) {
        return autorRepository.findById(id).orElse(null);
    }

}
