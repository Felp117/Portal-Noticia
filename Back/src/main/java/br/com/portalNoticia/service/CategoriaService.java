package br.com.portalNoticia.service;

import br.com.portalNoticia.entity.Categoria;
import br.com.portalNoticia.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria findById(Integer id) {
        return categoriaRepository.findById(id).orElse(null);
    }
}
