package br.com.portalNoticia.service;

import br.com.portalNoticia.entity.Autor;
import br.com.portalNoticia.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Service
@RequestMapping(value = "autor")
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    @RequestMapping(value = "/autor/{id}", method = RequestMethod.GET)
    public ResponseEntity<Autor> findById(@PathVariable(value = "id") Integer id) {
        Optional<Autor> autor = autorRepository.findById(id);
        return autor.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
