package br.com.portal.noticia.services;

import br.com.portal.noticia.dto.NoticiaDto;
import br.com.portal.noticia.entity.Autor;
import br.com.portal.noticia.entity.Categoria;
import br.com.portal.noticia.entity.Noticia;
import br.com.portal.noticia.repository.NoticiaRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoticiaService {

    private final NoticiaRepository repository;

    @Autowired
    public NoticiaService(NoticiaRepository repository) {
        this.repository = repository;
    }

    public List<Noticia> findAll() {
        return repository.findAll();
    }

    public Noticia findById(Integer id) throws BadRequestException {
        Optional<Noticia> noticia = repository.findById(id);
        if(noticia.isEmpty()) {
            throw new BadRequestException("Noticia não encontrada");
        }
        return noticia.get();
    }

    public Noticia insert(Noticia noticia) {
        return repository.save(noticia);
    }

    public void delete(Integer id) throws BadRequestException {
        findById(id);
        repository.deleteById(id);
    }

    public Noticia update (Noticia obj) throws BadRequestException{
        Noticia noticia = findById(obj.getId());
        noticiaUpdate(noticia, obj);
        return repository.save(noticia);
    }

    private void noticiaUpdate(Noticia antigo, Noticia novo) {
        antigo.setAutor(novo.getAutor());
        antigo.setCategoria(novo.getCategoria());
        antigo.setConteudo(novo.getConteudo());
        antigo.setTitulo(novo.getTitulo());
        antigo.setDataPublicacao(novo.getDataPublicacao());
    }

    public Noticia fromDto(NoticiaDto dto) {
        Categoria categoria = new Categoria();
        categoria.setId(dto.getCategoriaId());

        Autor autor = new Autor();
        autor.setId(dto.getAutorId());
        return new Noticia(
                dto.getId(),
                dto.getTitulo(),
                dto.getConteudo(),
                dto.getDataPublicacao(),
                categoria,
                autor
        );
    }
}
