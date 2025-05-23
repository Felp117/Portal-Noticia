package br.com.portalNoticia.services;

import br.com.portalNoticia.dto.AutorDto;
import br.com.portalNoticia.dto.PessoaDto;
import br.com.portalNoticia.entity.Autor;
import br.com.portalNoticia.entity.Pessoa;
import br.com.portalNoticia.entity.Usuario;
import br.com.portalNoticia.repository.AutorRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    private AutorRepository repository;

    public List<Autor> findAll() {
        return repository.findAll();
    }

    public Autor findById(Integer id) throws BadRequestException {
        Optional<Autor> autor = repository.findById(id);
        if(autor.isEmpty()) {
            throw new BadRequestException("Autor/biografia não encontrada");
        }
        return autor.get();
    }

    public Autor insert(Autor autor) {
        return repository.save(autor);
    }

    public void delete(Integer id) throws BadRequestException {
        findById(id);
        repository.deleteById(id);
    }

    public void update(Autor obj) throws BadRequestException {
        Autor autor = findById(obj.getId());

    }

    private void autorUpdate(Autor novo, Autor antigo){
        novo.setBiografia(antigo.getBiografia());
    }

    public Autor fromDto(AutorDto autorDto) {
        Autor autor = new Autor();
        autor.setId(autorDto.getId());
        autor.setNome(autorDto.getNome());
        autor.setEmail(autorDto.getEmail());
        autor.setBiografia(autor.getBiografia());
        return autor;
    }

}
