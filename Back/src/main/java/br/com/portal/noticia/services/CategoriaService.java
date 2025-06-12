package br.com.portal.noticia.services;

import br.com.portal.noticia.entity.Categoria;
import br.com.portal.noticia.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private CategoriaRepository repository;

    public List<Categoria> findAll() {
        return repository.findAll();
    }

}
