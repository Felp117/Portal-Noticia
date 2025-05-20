package br.com.portalNoticia.service;

import br.com.portalNoticia.entity.Noticia;
import br.com.portalNoticia.repository.NoticiaRepository;
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
public class NoticiaService {

    @Autowired
    private NoticiaRepository noticiaRepository;

    @RequestMapping(value = "/noticia", method = RequestMethod.GET)
    public ResponseEntity<List<Noticia>> findAll() {
        return ResponseEntity.ok((List<Noticia>) noticiaRepository.findAll());
    }

    @RequestMapping(value = "/noticia/{id}", method = RequestMethod.GET)
    public ResponseEntity<Noticia> findById(@PathVariable(value = "id") Integer id) {
        Optional<Noticia> pessoa = noticiaRepository.findById(id);
        return pessoa.map(noticia -> new ResponseEntity<>(noticia, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/noticia", method = RequestMethod.POST)
    public ResponseEntity<Noticia> findByNew(@PathVariable(value = "id") Integer id, @RequestBody Noticia novoItem) {
        Optional<Noticia> pessoa = noticiaRepository.findById(id);
        if(pessoa.isPresent()) {
            return new ResponseEntity<>(noticiaRepository.save(novoItem), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @RequestMapping(value = "/noticia/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Noticia> findByUpdate(@PathVariable(value = "id") Integer id, @RequestBody Noticia updateItem) {
        Optional<Noticia> pessoa = noticiaRepository.findById(id);
        if(pessoa.isPresent()) {
            return new ResponseEntity<>(noticiaRepository.save(updateItem), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/noticia/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Noticia> findByDelete(@PathVariable(value = "id") Integer id) {
        Optional<Noticia> pessoa = noticiaRepository.findById(id);
        if(pessoa.isPresent()) {
            noticiaRepository.delete(pessoa.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
