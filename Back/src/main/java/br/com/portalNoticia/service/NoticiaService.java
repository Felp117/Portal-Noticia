package br.com.portalNoticia.service;

import br.com.portalNoticia.entity.Noticia;
import br.com.portalNoticia.repository.NoticiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticiaService {

    @Autowired
    private NoticiaRepository noticiaRepository;

    public Noticia findById(Integer id) {
        return noticiaRepository.findById(id).orElse(null);
    }

}
