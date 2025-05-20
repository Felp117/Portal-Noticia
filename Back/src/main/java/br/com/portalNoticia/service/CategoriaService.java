package br.com.portalNoticia.service;

import br.com.portalNoticia.entity.Categoria;
import br.com.portalNoticia.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @RequestMapping(value = "/categoria", method = RequestMethod.GET)
    public ResponseEntity<List<Categoria>> findAll() {
        return ResponseEntity.ok((List<Categoria>) categoriaRepository.findAll());
    }

    @RequestMapping(value = "/categoria/{id}", method = RequestMethod.GET)
    public ResponseEntity<Categoria> findById(@PathVariable(value = "id") Integer id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/categoria", method = RequestMethod.POST)
    public ResponseEntity<Categoria> findByNew(@PathVariable(value = "id") Integer id, @RequestBody Categoria novoItem) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if(categoria.isPresent()) {
            return new ResponseEntity<>(categoriaRepository.save(novoItem), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @RequestMapping(value = "/categoria/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Categoria> findByUpdate(@PathVariable(value = "id") Integer id, @RequestBody Categoria updateItem) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if(categoria.isPresent()) {
            return new ResponseEntity<>(categoriaRepository.save(updateItem), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/categoria/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Categoria> findByDelete(@PathVariable(value = "id") Integer id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if(categoria.isPresent()) {
            categoriaRepository.delete(categoria.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
