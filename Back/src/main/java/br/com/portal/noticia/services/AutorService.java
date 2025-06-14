package br.com.portal.noticia.services;

import br.com.portal.noticia.entity.Autor;
import br.com.portal.noticia.repository.AutorRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    @Autowired
    private AutorRepository repository;

    public List<Autor> findAll() {
        return repository.findAll();
    }

    public Autor findById(Integer id) throws BadRequestException {
        Optional<Autor> autor = repository.findById(id);
        if(autor.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi possivel encontrar o autor com ID: " + id);
        }
        return autor.get();
    }

    public Autor insert(Autor autor) {
        return repository.save(autor);
    }

    public void delete(Integer id) throws BadRequestException {
        repository.deleteById(id);
    }

}
